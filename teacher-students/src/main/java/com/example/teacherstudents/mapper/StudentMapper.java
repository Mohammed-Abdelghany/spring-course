package com.example.teacherstudents.mapper;

import com.example.teacherstudents.dto.StudentDto;
import com.example.teacherstudents.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    public Student toStudent(StudentDto student);
    public List<Student> toStudents(List<StudentDto> students);

    public StudentDto toStudentDto(Student student);
    public List<StudentDto> toStudentsDto(List<Student> students);
}

