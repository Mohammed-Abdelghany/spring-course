package com.global.hr.repository;

import com.global.hr.model.Employee;

import java.util.List;

public interface EmployeeInterface {
   public int count();
   Employee findById(Long id);
   List<Employee> findAll();
   Employee save(Employee employee);
   Employee update(Employee employee);
   void delete(Employee employee);


}
