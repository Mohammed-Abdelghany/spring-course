package com.example.universitycoursemanagementsystem.controller;

import com.example.universitycoursemanagementsystem.dto.CourseDto;
import com.example.universitycoursemanagementsystem.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDto> getCourses() {
        return courseService.getAllCourses();

    }
    @GetMapping("/{id}")
    public Optional<CourseDto> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }
    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);}
    @PutMapping("/{id}")
    public CourseDto updateCourse( @RequestBody CourseDto courseDto) {
        return courseService.updateCourse(courseDto);   }
    @DeleteMapping("/{id}")

    public ResponseEntity<CourseDto> deleteCourse(@PathVariable @Valid Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

}
