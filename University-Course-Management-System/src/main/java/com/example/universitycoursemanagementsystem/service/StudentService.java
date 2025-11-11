package com.example.universitycoursemanagementsystem.service;

import com.example.universitycoursemanagementsystem.dto.StudentDto;
import com.example.universitycoursemanagementsystem.model.Student;

import java.util.List;

public interface StudentService {
    public List<StudentDto> getAllStudents();
    public StudentDto getStudentById(Long id);
    public Student createStudent(StudentDto studentDto);
    public StudentDto updateStudent(Long id, StudentDto studentDto);
    public void deleteStudent(Long id);

}
