package com.global.hr.controller;

import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeInterface employeeInterfaceImp;
    public EmployeeController(EmployeeInterface employeeInterfaceImp) {
        this.employeeInterfaceImp = employeeInterfaceImp;

    }
@GetMapping
    public int countEmployee(){
        return employeeInterfaceImp.count();
    }
@GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable Long id){
        return employeeInterfaceImp.findById(id);
    }
    @DeleteMapping("/{id}")
    public boolean isDeleted(@PathVariable Long id){
        Employee emp=employeeInterfaceImp.findById(id);
        if(emp!=null){
            employeeInterfaceImp.delete(emp);
            return true;
        }
        return false;
    }




}
