package com.example.universitycoursemanagementsystem.service.imp;

import com.example.universitycoursemanagementsystem.dto.InstructorDto;
import com.example.universitycoursemanagementsystem.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImp implements InstructorService {
    @Override
    public List<InstructorDto> getAllInstructors() {
        return List.of();
    }

    @Override
    public InstructorDto getInstructorById(Long id) {
        return null;
    }

    @Override
    public InstructorDto createInstructor(InstructorDto instructorDto) {
        return null;
    }

    @Override
    public InstructorDto updateInstructor(Long id, InstructorDto instructor) {
        return null;
    }

    @Override
    public void deleteInstructor(Long id) {

    }
}
