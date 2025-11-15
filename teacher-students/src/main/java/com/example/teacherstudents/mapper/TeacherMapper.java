package com.example.teacherstudents.mapper;

import com.example.teacherstudents.dto.StudentDto;
import com.example.teacherstudents.dto.TeacherDto;
import com.example.teacherstudents.model.Student;
import com.example.teacherstudents.model.Teacher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
 public TeacherDto toTeacherDto(Teacher teacher);
    public Teacher toTeacher (TeacherDto teacherDto);
    public List<TeacherDto> toTeacherDtoList(List<Teacher> teacherList);
    public List<Teacher> toTeacherList(List<TeacherDto> teacherDtoList);

}
