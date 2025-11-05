package com.example.simplecrudproject.service;

import com.example.simplecrudproject.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    public List<Teacher> getAllTeachers();
    public Optional<Teacher> getTeacherById(Long id);
    public Teacher createTeacher(Teacher teacher);
    public Teacher updateTeacher( Teacher teacher);
    public void deleteTeacher(Long id);
}
