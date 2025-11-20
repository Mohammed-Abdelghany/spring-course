package com.example.teacherstudents.controller;

import com.example.teacherstudents.config.JwtHandler;
import com.example.teacherstudents.controller.vm.LoginRequestVm;
import com.example.teacherstudents.controller.vm.LoginResponseVm;
import com.example.teacherstudents.dto.TeacherDto;
import com.example.teacherstudents.service.TeacherService;
import com.example.teacherstudents.service.imp.BundleMessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
private final TeacherService teacherService;
private final JwtHandler jwtHandler;
@Autowired
public AuthController(TeacherService teacherService,JwtHandler jwtHandler) {
    this.teacherService = teacherService;
    this.jwtHandler = jwtHandler;
}
    @PostMapping
    public ResponseEntity<LoginResponseVm> login(@Valid @RequestBody LoginRequestVm loginRequestVm) {
    Optional<TeacherDto> teacherDto=teacherService.getTeacherByUserName(loginRequestVm.getUsername());
    if (teacherDto.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
    }
    TeacherDto teacher = teacherDto.get();
    if (!teacher.getPassword().equals(loginRequestVm.getPassword())) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
    }
        // Implementation for user login
        return  new ResponseEntity<>(
                new LoginResponseVm(
                        jwtHandler.generateToken(teacher),teacherDto.get()
                ),HttpStatus.OK
        );
    }
    @PostMapping("/register")
    public ResponseEntity <TeacherDto> register() {
        // Implementation for user registration
        return null;
    }
}
