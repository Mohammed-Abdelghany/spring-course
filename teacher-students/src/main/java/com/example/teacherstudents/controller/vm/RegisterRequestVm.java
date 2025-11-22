package com.example.teacherstudents.controller.vm;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestVm {
    @NotBlank(message = "register.username.required")
    private String username;
    @NotBlank(message = "register.password.required")
    private String password;
    @NotBlank(message = "register.email.required")
    @Email
    private String email;

}
