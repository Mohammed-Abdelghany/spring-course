package com.example.teacherstudents.controller;

import com.example.teacherstudents.dto.TeacherDto;
import com.example.teacherstudents.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable @Valid Long id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public TeacherDto createTeacher(@RequestBody @Valid TeacherDto teacherDto) {
        return teacherService.createTeacher(teacherDto);
    }

    @PutMapping
    public TeacherDto updateTeacher(@RequestBody @Valid TeacherDto teacherDto) {
        return teacherService.updateTeacher(teacherDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable @Valid Long id) {
        teacherService.deleteTeacher(id);
    }




}
