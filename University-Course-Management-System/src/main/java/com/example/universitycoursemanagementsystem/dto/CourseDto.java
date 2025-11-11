package com.example.universitycoursemanagementsystem.dto;
import com.example.universitycoursemanagementsystem.model.Instructor;
import com.example.universitycoursemanagementsystem.model.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDto {
    @Null
    private Long id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotNull(message = "Description is required")
    private String description;
    @Null
    private List<StudentDto> students;
    private InstructorDto instructor;
    private Long instructor_id;




}
