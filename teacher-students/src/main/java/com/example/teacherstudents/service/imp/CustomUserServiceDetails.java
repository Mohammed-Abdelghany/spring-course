package com.example.teacherstudents.service.imp;

import com.example.teacherstudents.dto.TeacherDto;
import com.example.teacherstudents.helper.CustomUserDetails;
import com.example.teacherstudents.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserServiceDetails implements UserDetailsService {
    private final TeacherService teacherService;
    @Autowired
    public CustomUserServiceDetails(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<TeacherDto> teacherDto =teacherService.getTeacherByUserName(username);

    if (teacherDto.isEmpty()){
        throw new UsernameNotFoundException("User not found with username: " + username);

    }
        TeacherDto teacher = teacherDto.get();
    return new CustomUserDetails(teacher);
}}
