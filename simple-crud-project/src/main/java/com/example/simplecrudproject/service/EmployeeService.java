package com.example.simplecrudproject.service;

import com.example.simplecrudproject.dto.EmployeeDto;
import com.example.simplecrudproject.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<EmployeeDto> getAllEmployees();
    public Optional<EmployeeDto> getEmployeeById(Long id);
    public EmployeeDto createEmployee(EmployeeDto employee);
    public EmployeeDto updateEmployee( EmployeeDto employee);
    public void deleteEmployee(Long id);
    public List<EmployeeDto> getEmployeesByID(List<Long> ids);
    public List<EmployeeDto> createEmployees(List<EmployeeDto> employees);
    public List<EmployeeDto> updateEmployees( List<EmployeeDto> employees);
    public void deleteEmployees(List<Long> ids);
    public void deleteAllEmployees();
    public List<EmployeeDto> searchByName(String prefix);
}
