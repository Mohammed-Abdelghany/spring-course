package com.example.teacherstudents.repo;

import com.example.teacherstudents.dto.TeacherDto;
import com.example.teacherstudents.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

Teacher findByUsername(String username);
}
