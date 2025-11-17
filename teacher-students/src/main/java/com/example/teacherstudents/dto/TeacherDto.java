package com.example.teacherstudents.dto;

import com.example.teacherstudents.model.Role;
import com.example.teacherstudents.model.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
 public class TeacherDto {
        private Long id;
        @NotBlank(message = "teacher.name.required")
        private String username;
        @NotBlank(message = "teacher.email.required")
        @Email(message = "teacher.email.invalid")
        private String email;
        private List<Student> students;
        private String password;
        private List<RoleDto> roles;


}



