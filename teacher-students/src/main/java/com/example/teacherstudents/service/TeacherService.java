package com.example.teacherstudents.service;


import com.example.teacherstudents.dto.TeacherDto;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    public List<TeacherDto> getAllTeachers();
    public TeacherDto getTeacherById(Long id);
    public TeacherDto createTeacher(TeacherDto teacher);
    public TeacherDto updateTeacher(TeacherDto teacher);
    public void deleteTeacher(Long id);
    public Optional<TeacherDto>  getTeacherByUserName(String username);

}
