package com.example.simplecrudproject.control;
import com.example.simplecrudproject.dto.EmployeeDto;
import com.example.simplecrudproject.model.Employee;
import com.example.simplecrudproject.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService  employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeDto> getEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")

    public EmployeeDto getEmployee(@PathVariable @Valid Long id) {
        return  employeeService.getEmployeeById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }
    @GetMapping("/by-ids")
    public List<EmployeeDto> getEmployeesByIDs(@RequestParam @Valid List<Long> ids) {
        return employeeService.getEmployeesByID(ids);
    }

    @PostMapping("/save")
    public EmployeeDto createEmployee(@RequestBody @Valid EmployeeDto  employeeDto) {

  try{
        return employeeService.createEmployee(employeeDto);
  }
    catch (Exception e){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Employee Data");
    }


    }
    @PostMapping("/save/list-employees")
    public List<EmployeeDto> createEmployee(@RequestBody List<EmployeeDto> employees) {

        try {
            return employeeService.createEmployees(employees);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Employees Data");
        }
    }
    @PutMapping("/edit")
    public EmployeeDto updateEmployee(@RequestBody @Valid EmployeeDto employee) {

        return employeeService.updateEmployee(employee);

    }
    @PutMapping("/edit/list-employees")
    public List<EmployeeDto> updateEmployee(@RequestBody @Valid List<EmployeeDto> employees) {
        return employeeService.updateEmployees(employees);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable @Valid Long id) {
      employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/by-ids")
    public ResponseEntity<Void> deleteEmployees(@RequestParam  @Valid List<Long> ids) {
        employeeService.deleteEmployees(ids);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all-employees")
    public ResponseEntity<Void> deleteEmployee() {
        employeeService.deleteAllEmployees();
        return ResponseEntity.noContent().build();
    }

   @GetMapping("/employee/search-by-name")
   public List<EmployeeDto> searchEmployees(@RequestParam @Valid String name) {
         return employeeService.searchByName(name);
    }


}
