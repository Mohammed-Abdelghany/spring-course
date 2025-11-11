package com.example.universitycoursemanagementsystem.service;


import com.example.universitycoursemanagementsystem.dto.CourseDto;
import com.example.universitycoursemanagementsystem.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
public List<CourseDto> getAllCourses();
public Optional<CourseDto> getCourseById(Long id);
public CourseDto createCourse(CourseDto course);
public CourseDto updateCourse( CourseDto course);
public void deleteCourse(Long id);

}
