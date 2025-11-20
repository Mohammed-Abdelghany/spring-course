package com.example.teacherstudents.controller.vm;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginRequestVm {
    @NotBlank(message = "login.username.required")
    private String username;
    @NotBlank(message = "login.password.required")
    private String password;

}
