package com.example.teacherstudents.mapper;

import com.example.teacherstudents.dto.RoleDto;
import com.example.teacherstudents.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeacherMapper.class})
public interface RoleMapper {
    public Role roleDtoToRole(RoleDto roleDto);
    public RoleDto roleToRoleDto(Role role);

    public List<Role> roleDtoToRoleList(List<RoleDto> roleDtoList);
    public List<RoleDto> roleToRoleDtoList(List<Role> roleList);
}
