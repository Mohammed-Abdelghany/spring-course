package com.example.simplecrudproject.service;

import com.example.simplecrudproject.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeeById(Long id);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee( Employee employee);
    public void deleteEmployee(Long id);
    public List<Employee> getEmployeesByID(List<Long> ids);
    public List<Employee> createEmployees(List<Employee> employees);
    public List<Employee> updateEmployees( List<Employee> employees);
    public void deleteEmployees(List<Long> ids);
    public void deleteAllEmployees();
    public List<Employee> searchByName(String prefix);
}
