package com.example.teacherstudents.repo;

import com.example.teacherstudents.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Optional<Object> findByCode(String teacher);
}
