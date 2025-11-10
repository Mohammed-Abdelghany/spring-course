package com.example.simplecrudproject.service.impl;

import com.example.simplecrudproject.dto.EmployeeDto;
import com.example.simplecrudproject.mapper.EmployeeMapper;
import com.example.simplecrudproject.model.Employee;
import com.example.simplecrudproject.repo.EmployeeRepo;
import com.example.simplecrudproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService {
private final EmployeeRepo employeeRepo;
private final EmployeeMapper employeeMapper;
@Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo, EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
      this.employeeMapper = employeeMapper;
}

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
    Employee employee= employeeRepo.findById(employeeDto.getId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        employee.setName(employeeDto.getName());
        employee.setUsername(employeeDto.getUsername());
        employee.setPassword(employeeDto.getPassword());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        Employee saved = employeeRepo.save(employee);
        return employeeMapper.toEmployeeDto(saved);

    }

    @Override
    public void deleteEmployee(Long id) {
    employeeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        employeeRepo.deleteById(id);

    }



    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
    Employee employee= new Employee();
    employee.setName(employeeDto.getName());
    employee.setUsername(employeeDto.getUsername());
    employee.setPassword(employeeDto.getPassword());
    employee.setPhoneNumber(employeeDto.getPhoneNumber());
    Employee savedEmployee= employeeRepo.save(employee);
    employeeDto.setId(savedEmployee.getId());
    return employeeDto;


    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employeeMapper.toEmployeeDtoList(employees);
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(Long id) {
    Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        EmployeeDto employeesDto=employeeMapper.toEmployeeDto(employee);
        return Optional.of(employeesDto);
    }
    public List<EmployeeDto> getEmployeesByID(List<Long> ids) {
    List <Employee> employees = employeeRepo.findAllById(ids);
        return  employeeMapper.toEmployeeDtoList(employees);
    }

    @Override
    public List<EmployeeDto> createEmployees(List<EmployeeDto> employeesDto) {
        List<Employee> employees= employeesDto.stream().map(employeeMapper::toEmployee).toList();
        List<Employee> savedEmployees = employeeRepo.saveAll(employees);
        return employeeMapper.toEmployeeDtoList(savedEmployees);
    }

    @Override
    public List<EmployeeDto> updateEmployees( List<EmployeeDto> employeesDto) {
        for (EmployeeDto employeeDto : employeesDto) {
            if (employeeDto.getId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee ID must not be null for update");
            }
        }

        List<Employee> employees = employeesDto.stream().map(
                dto -> {
                    Employee existingEmployee = employeeRepo.findById(dto.getId())
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with ID: " + dto.getId()));
                    existingEmployee.setName(dto.getName());
                    existingEmployee.setUsername(dto.getUsername());
                    existingEmployee.setPassword(dto.getPassword());
                    existingEmployee.setPhoneNumber(dto.getPhoneNumber());
                    return existingEmployee;

        }).toList();
        return employeeRepo.saveAll(employees).stream().map(employeeMapper::toEmployeeDto ).toList();
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
    public List<EmployeeDto> searchByName(String name) {
//        return employeeRepo.findByNameStartingWith(name);
//            return  employeeRepo.searchByName(name);
        return employeeRepo.nativeSearchByName(name).stream().map(employeeMapper::toEmployeeDto).toList();



    }

}
