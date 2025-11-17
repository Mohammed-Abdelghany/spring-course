package com.example.teacherstudents.service.imp;

import com.example.teacherstudents.dto.TeacherDto;
import com.example.teacherstudents.mapper.StudentMapper;
import com.example.teacherstudents.mapper.TeacherMapper;
import com.example.teacherstudents.model.Student;
import com.example.teacherstudents.model.Teacher;
import com.example.teacherstudents.repo.StudentRepo;
import com.example.teacherstudents.repo.TeacherRepo;
import com.example.teacherstudents.service.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService {
    private final TeacherMapper teacherMapper;
    private final TeacherRepo teacherRepo;
    private final StudentRepo studentRepo;

    @Autowired
    public TeacherServiceImp (TeacherMapper teacherMapper, TeacherRepo teacherRepo, StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
        this.teacherMapper = teacherMapper;
        this.teacherRepo = teacherRepo;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        return teacherMapper.toTeacherDtoList(teacherRepo.findAll());
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        return teacherRepo.findById(id).map(teacherMapper::toTeacherDto).orElseThrow(() -> new IllegalArgumentException("Teacher not found with ID: " + id));
    }

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        if (Objects.nonNull(teacherDto.getId())){
            throw new IllegalArgumentException("New teacher cannot already have an ID");
        }
        if (Objects.nonNull(teacherDto.getStudents())){
            throw new IllegalArgumentException("Cannot assign students while creating a teacher");
        }
         return teacherMapper.toTeacherDto(teacherRepo.save(teacherMapper.toTeacher(teacherDto)));
        }


    @Override
    @Transactional
    public TeacherDto updateTeacher(TeacherDto teacherDto) {

        if (Objects.isNull(teacherDto.getId())) {
            throw new IllegalArgumentException("Teacher ID is required for update");
        }

        Teacher existingTeacher = teacherRepo.findById(teacherDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Teacher not found with ID: " + teacherDto.getId()));

        if (teacherDto.getEmail() != null) {
            existingTeacher.setEmail(teacherDto.getEmail());
        }

        if (teacherDto.getUsername() != null) {
            existingTeacher.setUsername(teacherDto.getUsername());
        }

        if (teacherDto.getStudents() != null) {

            existingTeacher.getStudents().forEach(student -> student.setTeacher(null));
            existingTeacher.getStudents().clear();

            List<Student> newStudents = teacherDto.getStudents()
                    .stream()
                    .map(s -> studentRepo.findById(s.getId())
                            .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + s.getId())))
                    .toList();

            newStudents.forEach(student -> student.setTeacher(existingTeacher));

            existingTeacher.setStudents(newStudents);
        }
        teacherRepo.save(existingTeacher);
        return teacherMapper.toTeacherDto(existingTeacher);
    }

    @Override
    @Transactional
    public void deleteTeacher(Long id) {
        if (!teacherRepo.existsById(id)) {
            throw new IllegalArgumentException("Teacher not found with ID: " + id);
        }
        teacherRepo.deleteById(id);

    }

    @Override
    public Optional<TeacherDto> getTeacherByUserName(String username) {
        TeacherDto teacherDto= teacherMapper.toTeacherDto(teacherRepo.findByUsername(username));
        return Optional.ofNullable(teacherDto);
    }
}
