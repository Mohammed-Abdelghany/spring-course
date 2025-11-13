package com.example.universitycoursemanagementsystem.service.imp;

import com.example.universitycoursemanagementsystem.dto.StudentDto;
import com.example.universitycoursemanagementsystem.mapper.StudentMapper;
import com.example.universitycoursemanagementsystem.model.Course;
import com.example.universitycoursemanagementsystem.model.Student;
import com.example.universitycoursemanagementsystem.repo.CourseRepo;
import com.example.universitycoursemanagementsystem.repo.StudentRepo;
import com.example.universitycoursemanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;
    private final CourseRepo courseRepo;

    @Autowired
    public StudentServiceImp(StudentRepo studentRepo, StudentMapper studentMapper, CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
        this.studentMapper = studentMapper;
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentMapper.studentToStudentDtoList( studentRepo.findAll());
    }

    @Override
    public Optional<StudentDto> getStudentById(Long id) {
        Optional<Student> studentDto=studentRepo.findById(id);
        if(studentDto.isPresent()){
            return studentDto.map(studentMapper::studentToStudentDto);
        }
        throw new IllegalArgumentException("Student not found with ID: " + id);

    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        if(Objects.nonNull(studentDto.getId())){
            throw new IllegalArgumentException("New student cannot already have an ID");
        }
        Student student=studentMapper.studentDtoToStudent(studentDto);
        return studentMapper.studentToStudentDto(studentRepo.save(student));
    }

    @Override
    public StudentDto updateStudent( StudentDto studentDto) {
        if (Objects.isNull(studentDto.getId())) {
            throw new IllegalArgumentException("Student ID is required for update");
        }

        Student existingStudent=studentRepo.findById(studentDto.getId()).orElse(null);
        if(existingStudent!=null){
            if (studentDto.getName()!= null) {
                existingStudent.setName(studentDto.getName());
            }
            if (studentDto.getEmail() != null) {
                existingStudent.setEmail(studentDto.getEmail());
            }
            if (studentDto.getCourses()!=null&& !studentDto.getCourses().isEmpty()){
                List<Course> courses= courseRepo.findAllById(
                        studentDto.getCourses().stream()
                                .map(Course::getId)
                                .toList()
                );
                existingStudent.setCourses(courses);
            }
            Student updatedStudent=studentRepo.save(existingStudent);
            return studentMapper.studentToStudentDto(updatedStudent);
        }
        throw new IllegalArgumentException("Student not found with ID: " + studentDto.getId());
    }

    @Override
    public void deleteStudent(Long id) {
        if(studentRepo.findById(id).isPresent()){
            studentRepo.deleteById(id);
            return;
        }
        throw new IllegalArgumentException("Student not found with ID: " + id);

    }
    @Override
    public void assignCourseToStudent(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + studentId));

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseId));

        student.getCourses().add(course);
        studentRepo.save(student);
    }
}
