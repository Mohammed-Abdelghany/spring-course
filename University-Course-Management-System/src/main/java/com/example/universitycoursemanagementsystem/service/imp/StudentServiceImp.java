package com.example.universitycoursemanagementsystem.service.imp;

import com.example.universitycoursemanagementsystem.dto.StudentDto;
import com.example.universitycoursemanagementsystem.model.Student;
import com.example.universitycoursemanagementsystem.repo.StudentRepo;
import com.example.universitycoursemanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    private StudentRepo studentRepo;
    @Autowired
    public StudentServiceImp(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentDto> getAllStudents() {
             studentRepo.findAll() ;
        return null;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return null;
    }

    @Override
    public Student createStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
