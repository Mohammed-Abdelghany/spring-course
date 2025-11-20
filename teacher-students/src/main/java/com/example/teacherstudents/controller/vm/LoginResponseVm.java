package com.example.teacherstudents.controller.vm;

import com.example.teacherstudents.dto.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseVm {
    private String Token;
    private TeacherDto Teacher;
}
