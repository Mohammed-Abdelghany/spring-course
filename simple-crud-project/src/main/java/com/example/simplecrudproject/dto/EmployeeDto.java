package com.example.simplecrudproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    @Null
    private Long id;
    @NotBlank(message="Name cannot be blank")
        private String name;
    @NotBlank(message="Username cannot be blank")
        private String username;
    @NotBlank(message="Password cannot be blank")
        private String password;
    @NotBlank(message="Phone number cannot be blank")
    @Size (min=10, max=15, message="Phone number must be between 10 and 15 characters")
        private String phoneNumber;

    }


