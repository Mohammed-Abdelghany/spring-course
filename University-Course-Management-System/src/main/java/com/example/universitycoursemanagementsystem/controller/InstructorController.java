package com.example.universitycoursemanagementsystem.controller;

import com.example.universitycoursemanagementsystem.dto.InstructorDto;
import com.example.universitycoursemanagementsystem.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping

    public List<InstructorDto> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{id}")
    public InstructorDto getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
    }

    @PostMapping
    public InstructorDto createInstructor(@RequestBody InstructorDto instructorDto) {
        return instructorService.createInstructor(instructorDto);
    }

    @PutMapping
    public InstructorDto updateInstructor(@RequestBody InstructorDto instructorDto) {
        return instructorService.updateInstructor(instructorDto);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
    }
    @PostMapping("/{instructorId}/courses/{courseId}")
    public void assignCourseToInstructor(
            @PathVariable Long instructorId,
            @PathVariable Long courseId) {
        instructorService.assignCourseToInstructor(instructorId, courseId);
    }
}
