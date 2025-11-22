package com.example.teacherstudents.controller;

import com.example.teacherstudents.config.JwtHandler;
import com.example.teacherstudents.controller.vm.LoginRequestVm;
import com.example.teacherstudents.controller.vm.LoginResponseVm;
import com.example.teacherstudents.controller.vm.RegisterRequestVm;
import com.example.teacherstudents.controller.vm.RegisterResponseVm;
import com.example.teacherstudents.dto.RoleDto;
import com.example.teacherstudents.dto.TeacherDto;
import com.example.teacherstudents.mapper.RoleMapper;
import com.example.teacherstudents.mapper.TeacherMapper;
import com.example.teacherstudents.model.Role;
import com.example.teacherstudents.repo.RoleRepo;
import com.example.teacherstudents.service.TeacherService;
import com.example.teacherstudents.service.imp.BundleMessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
private final TeacherService teacherService;
private final JwtHandler jwtHandler;
private final RoleRepo roleRepo;
private final RoleMapper roleMapper;
@Autowired
public AuthController(TeacherService teacherService, JwtHandler jwtHandler, RoleRepo roleRepo , RoleMapper roleMapper) {
    this.teacherService = teacherService;
    this.jwtHandler = jwtHandler;
    this.roleRepo = roleRepo;
    this.roleMapper = roleMapper;
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
    @Transactional
    public ResponseEntity <RegisterResponseVm> register(@Valid @RequestBody RegisterRequestVm registerRequestVm) {
        // Implementation for user registration
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setUsername(registerRequestVm.getUsername());
        teacherDto.setPassword(registerRequestVm.getPassword());
        teacherDto.setEmail(registerRequestVm.getEmail());
        RoleDto roleDto = new RoleDto();
        Role role= (Role) roleRepo.findByCode("TEACHER").orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Role not found"));
        teacherDto.setRoles(roleMapper.roleToRoleDtoList(List.of(role)));
        TeacherDto createdTeacher = teacherService.createTeacher(teacherDto);
        return new ResponseEntity<>(
                new RegisterResponseVm(
                        jwtHandler.generateToken(createdTeacher),
                        teacherDto
                ),HttpStatus.OK
        );
    }
}
