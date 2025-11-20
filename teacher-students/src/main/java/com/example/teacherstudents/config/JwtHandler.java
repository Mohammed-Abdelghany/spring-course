package com.example.teacherstudents.config;

import com.example.teacherstudents.dto.RoleDto;
import com.example.teacherstudents.dto.TeacherDto;
import com.example.teacherstudents.helper.JwtToken;
import com.example.teacherstudents.service.TeacherService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JwtHandler {
    private JwtBuilder jwtBuilder;
    private JwtParser jwtParser;
    private Duration expiration;
    private TeacherService teacherService;
    @Autowired
public JwtHandler(JwtToken jwtToken, TeacherService teacherService) {
Key key= Keys.hmacShaKeyFor(jwtToken.getSecretKey().getBytes(StandardCharsets.UTF_8));
    jwtBuilder= Jwts.builder().signWith(key);
    jwtParser= Jwts.parserBuilder().setSigningKey(key).build();
    this.teacherService=teacherService;

}


    public String generateToken(TeacherDto  teacherDto) {
Date now = new Date();
Date ExpiryDate = Date.from(now.toInstant().plus(expiration));
    return jwtBuilder
        .setSubject(teacherDto.getUsername())
        .setIssuedAt(now)
        .setExpiration(ExpiryDate)
        .claim("roles",teacherDto.getRoles().stream().map(RoleDto::getCode).toList())
        .compact();
    }


    public TeacherDto validateToken(String token) {
    if (!jwtParser.isSigned(token)) {
        return null;
    }
Claims claims = jwtParser.parseClaimsJws(token).getBody();
    String username = claims.getSubject();
    Date issued =  claims.getIssuedAt();
    Date exp =  claims.getExpiration();
Optional<TeacherDto> teacherDto = teacherService.getTeacherByUserName(username);
if (teacherDto.isPresent()) {
boolean tokenValid = issued.before(new Date()) && exp.after(new Date());
return tokenValid? teacherDto.get():null;
}
    return  null;
    }


}
