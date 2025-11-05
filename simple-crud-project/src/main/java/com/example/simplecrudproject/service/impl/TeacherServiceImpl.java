package com.example.simplecrudproject.service.impl;

import com.example.simplecrudproject.model.Teacher;
import com.example.simplecrudproject.repo.TeacherRepo;
import com.example.simplecrudproject.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class TeacherServiceImpl implements TeacherService {
private final TeacherRepo teacherRepo;
@Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public Teacher updateTeacher( Teacher teacher) {
    if (teacher.getId() == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Teacher ID must not be null for update");
    }
        return teacherRepo.save(teacher) ;
    }

    @Override
    public void deleteTeacher(Long id) {
    teacherRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
        teacherRepo.deleteById(id);

    }



    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }


    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepo.findById(id);
    }
}
