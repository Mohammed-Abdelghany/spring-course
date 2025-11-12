package com.example.universitycoursemanagementsystem.repo;

import com.example.universitycoursemanagementsystem.model.Instructor;
import com.example.universitycoursemanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {


    boolean existsByEmail(String email);
}