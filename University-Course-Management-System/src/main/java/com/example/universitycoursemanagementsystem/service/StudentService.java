package com.example.universitycoursemanagementsystem.service;

import com.example.universitycoursemanagementsystem.dto.StudentDto;
import com.example.universitycoursemanagementsystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<StudentDto> getAllStudents();
    public Optional<StudentDto> getStudentById(Long id);
    public StudentDto createStudent(StudentDto studentDto);
    public StudentDto updateStudent(StudentDto studentDto);
    public void deleteStudent(Long id);
    public void assignCourseToStudent(Long studentId, Long courseId);

}
