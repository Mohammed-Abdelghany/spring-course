package com.example.simplecrudproject.mapper;

import com.example.simplecrudproject.dto.EmployeeDto;
import com.example.simplecrudproject.model.Employee;
import org.mapstruct.Mapper;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
     //    private final ModelMapper modelMapper;
//    @Autowired
//    public EmployeeMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }

     EmployeeDto toEmployeeDto(Employee employee) ;
     Employee toEmployee(EmployeeDto employeeDto) ;

     List<EmployeeDto> toEmployeeDtoList(List<Employee> employeeList) ;
     List<Employee> toEmployeeList(List<EmployeeDto> employeeDtoList) ;


}
