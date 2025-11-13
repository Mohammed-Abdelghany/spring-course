package com.example.universitycoursemanagementsystem.controller;

import com.example.universitycoursemanagementsystem.dto.StudentDto;
import com.example.universitycoursemanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable @Valid Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid StudentDto studentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentDto));
    }

    @PutMapping
    public ResponseEntity<StudentDto> updateStudent(@RequestBody @Valid StudentDto studentDto) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(studentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable  @Valid Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<String> assignCourseToStudent(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {
        studentService.assignCourseToStudent(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK).body("Course assigned to student successfully");
    }
}
