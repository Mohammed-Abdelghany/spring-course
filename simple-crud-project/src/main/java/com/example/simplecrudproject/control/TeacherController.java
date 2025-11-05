package com.example.simplecrudproject.control;

import com.example.simplecrudproject.model.Teacher;
import com.example.simplecrudproject.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/teachers")

public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.getAllTeachers();
    }
    @GetMapping("/{id}")

    public Teacher getTeacher(@PathVariable Long id) {
        return  teacherService.getTeacherById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
    }
    @PostMapping("/save")
    public Teacher createTeacher(@RequestBody Teacher teacher) {

  try{
        return teacherService.createTeacher(teacher);
  }
    catch (Exception e){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Teacher Data");
    }
    }
    @PutMapping("/edit")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {

        return teacherService.updateTeacher(teacher);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
      teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
