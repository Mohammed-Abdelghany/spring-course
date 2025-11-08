package com.example.simplecrudproject.repo;

import com.example.simplecrudproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByNameStartingWith(String prefix);
    @Query("SELECT e From Employee e WHERE e.name LIKE:name%")
    List<Employee> searchByName(String name);
    @Query(value = "SELECT * FROM Employee WHERE username LIKE:name%", nativeQuery = true)
    List<Employee> nativeSearchByName(String name);


}
