package com.example.universitycoursemanagementsystem.service;

import com.example.universitycoursemanagementsystem.dto.InstructorDto;
import com.example.universitycoursemanagementsystem.model.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    public List<InstructorDto> getAllInstructors();
    public Optional<InstructorDto> getInstructorById(Long id);
    public InstructorDto createInstructor(InstructorDto instructorDto);
    public InstructorDto updateInstructor(InstructorDto instructor);
    public void deleteInstructor(Long id);

}
