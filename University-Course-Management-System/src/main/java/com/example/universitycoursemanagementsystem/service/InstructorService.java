package com.example.universitycoursemanagementsystem.service;

import com.example.universitycoursemanagementsystem.dto.InstructorDto;
import com.example.universitycoursemanagementsystem.model.Instructor;

import java.util.List;

public interface InstructorService {
    public List<InstructorDto> getAllInstructors();
    public InstructorDto getInstructorById(Long id);
    public InstructorDto createInstructor(InstructorDto instructorDto);
    public InstructorDto updateInstructor(Long id, InstructorDto instructor);
    public void deleteInstructor(Long id);

}
