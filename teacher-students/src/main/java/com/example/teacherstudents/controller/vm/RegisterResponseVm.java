package com.example.teacherstudents.controller.vm;

import com.example.teacherstudents.dto.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseVm {
    private String token;
    private TeacherDto teacherDto;
}
