package com.example.universitycoursemanagementsystem.service.imp;

import com.example.universitycoursemanagementsystem.dto.CourseDto;
import com.example.universitycoursemanagementsystem.dto.InstructorDto;
import com.example.universitycoursemanagementsystem.mapper.CourseMapper;
import com.example.universitycoursemanagementsystem.mapper.InstructorMapper;
import com.example.universitycoursemanagementsystem.mapper.StudentMapper;
import com.example.universitycoursemanagementsystem.model.Course;
import com.example.universitycoursemanagementsystem.model.Instructor;
import com.example.universitycoursemanagementsystem.repo.CourseRepo;
import com.example.universitycoursemanagementsystem.repo.InstructorRepo;
import com.example.universitycoursemanagementsystem.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService{
    private final CourseRepo courseRepo;
    private final InstructorRepo instructorRepo;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;
    private final InstructorMapper instructorMapper;
    @Autowired
    public CourseServiceImp(CourseRepo courseRepo, CourseMapper courseMapper, InstructorRepo instructorRepo , StudentMapper studentMapper, InstructorMapper instructorMapper) {
        this.instructorMapper = instructorMapper;

        this.instructorRepo = instructorRepo;
        this.courseMapper = courseMapper;
        this.courseRepo = courseRepo;
        this.studentMapper = studentMapper;
    }
    @Override
    public List<CourseDto> getAllCourses() {
        return courseMapper.toCourseDtoList(courseRepo.findAll());
    }

    @Override
    public Optional<CourseDto> getCourseById(Long id) {
        return  courseRepo.findById(id).map(courseMapper::toCourseDto);
    }

    @Override
    @Transactional
    public CourseDto createCourse(CourseDto courseDto) {
        if(Objects.nonNull(courseDto.getId()) ){
            throw new IllegalArgumentException("New course cannot already have an ID");
        }
        if (Objects.isNull(courseDto.getInstructor_id())) {
            throw new IllegalArgumentException("Instructor ID is required to create a course");
        }
        Instructor instructor = instructorRepo.findById(courseDto.getInstructor_id()).orElseThrow(() -> new IllegalArgumentException("Instructor not found with ID: " + courseDto.getInstructor_id()));
        if(Objects.nonNull(courseDto.getStudents())){
            throw new IllegalArgumentException("Cannot assign students while creating a course");
                    }
        Course course = courseMapper.toCourse(courseDto);
        course.setInstructor(instructor);
        Course savedCourse=     courseRepo.save(course);
        InstructorDto instructorDto= instructorMapper.toinstructorDto(instructor);
        courseDto.setInstructor(instructorDto);
        courseDto.setId( savedCourse.getId());
        return courseDto;

    }

    @Override
    @Transactional
    public CourseDto updateCourse( CourseDto courseDto) {
      if (Objects.isNull(courseDto.getId())) {
            throw new IllegalArgumentException("Course ID is required for update");
      }
        Course existingCourse= courseRepo.findById(courseDto.getId()).orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseDto.getId()));
        if (Objects.nonNull(courseDto.getInstructor_id())) {
        Instructor instructor = instructorRepo.findById(courseDto.getInstructor_id()).orElseThrow(() -> new IllegalArgumentException("Instructor not found with ID: " + courseDto.getInstructor_id()));
        existingCourse.setInstructor(instructor);
        }
        if (Objects.nonNull(courseDto.getDescription())) {
            existingCourse.setDescription(courseDto.getDescription());

        }
        if (Objects.nonNull(courseDto.getTitle())) {
            existingCourse.setTitle(courseDto.getTitle());

        }
        if(courseDto.getStudents() != null) {
            existingCourse.setStudents(studentMapper.studentDtoToStudentList(courseDto.getStudents()));
        }
        return courseMapper.toCourseDto( courseRepo.save(existingCourse));
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepo.existsById(id)) {
            throw new IllegalArgumentException("Course not found with ID: " + id);
        }
        courseRepo.deleteById(id);

    }
}
