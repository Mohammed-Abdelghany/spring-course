package com.example.simplecrudproject.control;

import com.example.simplecrudproject.model.Employee;
import com.example.simplecrudproject.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")

    public Employee getEmployee(@PathVariable Long id) {
        return  employeeService.getEmployeeById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }
    @GetMapping("/by-ids")
    public List<Employee> getEmployeesByIDs(@RequestParam List<Long> ids) {
        return employeeService.getEmployeesByID(ids);
    }

    @PostMapping("/save")
    public Employee createEmployee(@RequestBody Employee employee) {

  try{
        return employeeService.createEmployee(employee);
  }
    catch (Exception e){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Employee Data");
    }


    }
    @PostMapping("/save/list-employees")
    public List<Employee> createEmployee(@RequestBody List<Employee> employees) {

        try {
            return employeeService.createEmployees(employees);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Employees Data");
        }
    }
    @PutMapping("/edit")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.updateEmployee(employee);

    }
    @PutMapping("/edit/list-employees")
    public List<Employee> updateEmployee(@RequestBody List<Employee> employees) {
        return employeeService.updateEmployees(employees);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
      employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/by-ids")
    public ResponseEntity<Void> deleteEmployees(@RequestParam  List<Long> ids) {
        employeeService.deleteEmployees(ids);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all-employees")
    public ResponseEntity<Void> deleteEmployee() {
        employeeService.deleteAllEmployees();
        return ResponseEntity.noContent().build();
    }

   @GetMapping("/employee/search-by-name")
   public List<Employee> searchEmployees(@RequestParam String name) {
         return employeeService.searchByName(name);
    }


}
