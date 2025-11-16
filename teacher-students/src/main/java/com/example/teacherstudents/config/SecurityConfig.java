package com.example.teacherstudents.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth->auth.requestMatchers(HttpMethod.GET,"/teachers").hasRole("TEACHER").anyRequest().permitAll());
    http.formLogin(Customizer.withDefaults());
    http.httpBasic(Customizer.withDefaults());

    return http.build();
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        UserDetails user1= User.withUsername("moo").password("{noop}123").roles("TEACHER").build();
        return new InMemoryUserDetailsManager(user1);
    }
}
