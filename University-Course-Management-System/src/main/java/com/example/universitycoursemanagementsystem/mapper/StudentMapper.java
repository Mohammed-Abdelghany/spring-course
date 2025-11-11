package com.example.universitycoursemanagementsystem.mapper;

import com.example.universitycoursemanagementsystem.dto.StudentDto;
import com.example.universitycoursemanagementsystem.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface StudentMapper {

    public Student studentDtoToStudent(StudentDto studentDto);
    public StudentDto studentToStudentDto(Student student);

    public List<Student> studentDtoToStudentList(List<StudentDto> studentDtoList);
    public List<StudentDto> studentToStudentDtoList(List<Student> studentList);
}
