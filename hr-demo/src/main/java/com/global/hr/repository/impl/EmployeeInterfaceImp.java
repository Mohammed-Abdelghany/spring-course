package com.global.hr.repository.impl;

import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Component
public class EmployeeInterfaceImp implements EmployeeInterface {
    private final JdbcTemplate jdbcTemplate;
    public EmployeeInterfaceImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        Integer result = jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
     return (result != null) ? result : 0;
    }

    @Override
    public Employee findById(Long id) {
        try {
            return jdbcTemplate.queryForObject(
                                        "SELECT salary, id, name FROM employee WHERE id = ?",
                    (rs, rowNum) -> new Employee(
                            rs.getDouble("salary"),
                            rs.getLong("id"),
                            rs.getString("name")
                    ),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Employee with id " + id + " not found.");
            return null;
        }
    }



    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM employee",
                (rs, rowNum) -> new Employee(
                        rs.getDouble("salary"),
                        rs.getLong("id"),
                        rs.getString("name")
                )
        );
    }
    @Override
    public Employee save(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)",
                employee.getId(), employee.getName(), employee.getSalary());
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
jdbcTemplate.update("UPDATE employee SET name = ?, salary = ? WHERE id = ?",
        employee.getName(), employee.getSalary(), employee.getId());
        return employee;
    }

    @Override
    public void delete(Employee employee) {

        jdbcTemplate.update("DELETE FROM job_history WHERE employee_id = ?", employee.getId());
        jdbcTemplate.update("DELETE FROM employee WHERE id = ?", employee.getId());
    }
}
