package com.example.universitycoursemanagementsystem.mapper;

import com.example.universitycoursemanagementsystem.dto.InstructorDto;
import com.example.universitycoursemanagementsystem.model.Instructor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface InstructorMapper {

    public Instructor toinstructor(InstructorDto instructorDto);
    public InstructorDto toinstructorDto(Instructor instructor);

    public List<Instructor> toinstructorList(List<InstructorDto> instructorDtoList);
    public List<InstructorDto> toinstructorDtoList(List<Instructor> instructorList);
}
