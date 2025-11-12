package com.example.universitycoursemanagementsystem.service.imp;

import com.example.universitycoursemanagementsystem.dto.InstructorDto;
import com.example.universitycoursemanagementsystem.mapper.InstructorMapper;
import com.example.universitycoursemanagementsystem.model.Instructor;
import com.example.universitycoursemanagementsystem.repo.InstructorRepo;
import com.example.universitycoursemanagementsystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InstructorServiceImp implements InstructorService {
    private final InstructorMapper instructorMapper;
    private  final InstructorRepo instructorRepo;
    @Autowired
    public InstructorServiceImp(InstructorMapper instructorMapper, InstructorRepo instructorRepo) {
        this.instructorMapper = instructorMapper;
        this.instructorRepo  = instructorRepo;
    }

    @Override
    public List<InstructorDto> getAllInstructors() {

        return instructorMapper.toinstructorDtoList(instructorRepo.findAll());
    }

    @Override
    public Optional<InstructorDto> getInstructorById(Long id) {
        return instructorRepo.findById(id).map(instructorMapper::toinstructorDto);
    }

    @Override
    public InstructorDto createInstructor(InstructorDto instructorDto) {
        if (Objects.nonNull(instructorDto.getId())) {
            throw new IllegalArgumentException("New instructor cannot already have an ID");
        }

        Optional.ofNullable(instructorDto.getEmail()).ifPresent(
                email -> {
                    if (instructorRepo.existsByEmail((email))){
                        throw new IllegalArgumentException("Instructor with email " + email + " already exists");
                    }
                }
        );
        if (Objects.isNull(instructorDto.getEmail())) {
            throw new IllegalArgumentException("Instructor email is required");
        }
      Instructor  savedInstructor= instructorRepo.save(instructorMapper.toinstructor(instructorDto));
        return instructorMapper.toinstructorDto(savedInstructor);
    }

    @Override
    public InstructorDto updateInstructor(InstructorDto instructorDto) {
        if (Objects.isNull(instructorDto.getId())) {
            throw new IllegalArgumentException("Instructor ID is required for update");
        }
        Instructor exitingInstructor = instructorRepo.findById(instructorDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Instructor not found with ID: " + instructorDto.getId()));
//        if (Objects.nonNull(instructorDto.getEmail())){
//            exitingInstructor.setEmail(instructorDto.getEmail());
//        }
//        if (Objects.nonNull(instructorDto.getName())){
//            exitingInstructor.setName(instructorDto.getName());
//        }
        Optional.ofNullable(instructorDto.getName()).ifPresent(exitingInstructor::setName);
        Optional.ofNullable(instructorDto.getEmail()).ifPresent(exitingInstructor::setEmail);
        return instructorMapper.toinstructorDto(instructorRepo.save(exitingInstructor));
    }

    @Override
    public void deleteInstructor(Long id) {
        if (!instructorRepo.existsById(id)) {
            throw new IllegalArgumentException("Instructor not found with ID: " + id);
        }
        instructorRepo.deleteById(id);

    }
}
