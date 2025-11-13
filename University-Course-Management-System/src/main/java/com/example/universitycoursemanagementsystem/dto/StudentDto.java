package com.example.universitycoursemanagementsystem.dto;

import com.example.universitycoursemanagementsystem.model.Course;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {

    private Long id;
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    private List<Course> courses;
}
