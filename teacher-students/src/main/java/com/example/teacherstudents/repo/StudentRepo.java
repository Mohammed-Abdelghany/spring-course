package com.example.teacherstudents.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.teacherstudents.model.Student;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepo extends JpaRepository<Student, Long> {

}

