package com.example.universitycoursemanagementsystem.mapper;

import com.example.universitycoursemanagementsystem.dto.CourseDto;
import com.example.universitycoursemanagementsystem.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" ,uses={InstructorMapper.class})
public interface CourseMapper {
    public Course toCourse(CourseDto courseDto);
    public CourseDto toCourseDto(Course course);

    public List<Course> toCourseList(List<CourseDto> courseDtoList);
    public List<CourseDto> toCourseDtoList(List<Course> courseList);


}
