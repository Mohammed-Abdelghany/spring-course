package com.example.teacherstudents.config;

import com.example.teacherstudents.config.filters.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;
import java.security.Security;

@Configuration
public class SecurityConfig {

private final AuthFilter authFilter;

@Autowired
    public SecurityConfig(AuthFilter authFilter) {
    this.authFilter = authFilter;
}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    http.authorizeHttpRequests(auth->auth
            .requestMatchers(HttpMethod.POST, "/auth").permitAll()
            .requestMatchers(HttpMethod.GET,"/teachers").hasRole("ADMIN").anyRequest().permitAll());
    http.csrf(AbstractHttpConfigurer::disable);
    http.formLogin(AbstractHttpConfigurer::disable);
    http.httpBasic(AbstractHttpConfigurer::disable);
    http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
    }
//    @Bean
//    public UserDetailsService getUserDetailsService(DataSource dataSource) {
//
//        return new JdbcUserDetailsManager(dataSource);
//    }
}
