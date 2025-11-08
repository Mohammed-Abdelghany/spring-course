package com.example.simplecrudproject.service.impl;

import com.example.simplecrudproject.model.Employee;
import com.example.simplecrudproject.repo.EmployeeRepo;
import com.example.simplecrudproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService {
private final EmployeeRepo employeeRepo;
@Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee updateEmployee( Employee employee) {
    if (employee.getId() == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee ID must not be null for update");
    }
        return employeeRepo.save(employee) ;
    }

    @Override
    public void deleteEmployee(Long id) {
    employeeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        employeeRepo.deleteById(id);

    }



    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }
    public List<Employee> getEmployeesByID(List<Long> ids) {
        return employeeRepo.findAllById(ids);
    }

    @Override
    public List<Employee> createEmployees(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    @Override
    public List<Employee> updateEmployees( List<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee ID must not be null for update");
            }
        }
        return employeeRepo.saveAll(employees) ;
    }

    @Override
    public void deleteEmployees(List<Long> ids) {
        List<Employee> employees = employeeRepo.findAllById(ids);
        if (employees.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        employeeRepo.deleteAll(employees);
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepo.deleteAll();
    }
    @Override
    public List<Employee> searchByName(String name) {
//        return employeeRepo.findByNameStartingWith(name);
//            return  employeeRepo.searchByName(name);
        return employeeRepo.nativeSearchByName(name);


}

}
