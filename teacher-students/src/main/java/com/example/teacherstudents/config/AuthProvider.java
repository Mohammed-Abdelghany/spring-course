package com.example.teacherstudents.config;

import com.example.teacherstudents.dto.TeacherDto;
import com.example.teacherstudents.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
public class AuthProvider implements AuthenticationProvider {
    private final TeacherService teacherService;
//    @Autowired
   public AuthProvider(TeacherService teacherService) {
         this.teacherService = teacherService;

   }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
String username = authentication.getPrincipal().toString();
String password = authentication.getCredentials().toString();
       Optional <TeacherDto> teacherDto = teacherService.getTeacherByUserName(username);
       if (teacherDto.isPresent()) {
              TeacherDto teacher = teacherDto.get();
              if (teacher.getPassword().equals(password)) {
                return new UsernamePasswordAuthenticationToken(
                          username,
                          password,
                          teacher.getRoles().stream()
                                 .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getCode()))
                                 .toList()
                );
              }
              throw new BadCredentialsException("Bad credentials");
       }

       throw new BadCredentialsException("Invalid username or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class) ;
    }
}
