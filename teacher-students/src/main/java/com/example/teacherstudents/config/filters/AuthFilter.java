package com.example.teacherstudents.config.filters;

import com.example.teacherstudents.config.JwtHandler;
import com.example.teacherstudents.dto.TeacherDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component

public class AuthFilter extends OncePerRequestFilter {
public String token;
private final JwtHandler jwtHandler;
@Autowired
public AuthFilter(JwtHandler jwtHandler){
    this.jwtHandler=jwtHandler;
}
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            token = request.getHeader("Authorization");
            if (token == null ||!token.startsWith("Bearer ")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            token = token.substring(7);
            TeacherDto teacherDto = jwtHandler.validateToken(token);
            if (teacherDto == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            List<SimpleGrantedAuthority> roles = teacherDto.getRoles().stream().map(
                    role -> new SimpleGrantedAuthority("ROLE_" + role.getCode())
            ).toList();
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            teacherDto.getUsername(),
                            teacherDto.getPassword(),
                            roles
                    );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            filterChain.doFilter(request, response);
        } catch (IOException | ServletException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        }

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    String uri = request.getRequestURI();
        return uri.contains("/auth") ;
    }
}
