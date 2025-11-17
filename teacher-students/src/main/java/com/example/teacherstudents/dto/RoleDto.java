package com.example.teacherstudents.dto;

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
public class RoleDto  {

    private Long id;
    @NotBlank(message = "role.code.required")
    private String code;
    private List<TeacherDto> users;


}
