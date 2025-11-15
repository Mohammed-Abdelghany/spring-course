package com.example.teacherstudents.dto;

import com.example.teacherstudents.model.Teacher;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
public class StudentDto {
        private Long id;
        @NotBlank(message = "student.name.required")
        private String name;
        @NotBlank(message="student.email.required")
        @Email(message="student.email.invalid")
        private String email;
        private Teacher teacher;

    }




















