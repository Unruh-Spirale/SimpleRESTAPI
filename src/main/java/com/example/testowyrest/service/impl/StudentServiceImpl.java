package com.example.testowyrest.service.impl;

import com.example.testowyrest.entity.Student;
import com.example.testowyrest.repository.StudentRepository;
import com.example.testowyrest.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        Optional<Student> byId = studentRepository.findById(id);
        Student studentFromDb = byId.get();
//        Student studentFromDb = studentRepository.getById(id);
        return studentFromDb;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Long id, Student student) {
        Student studentFromDB = studentRepository.getById(id);
//        Student updatedStudent = studentBeforeUpdate.builder()
//                .firstName(student.getFirstName())
//                .lastName(student.getLastName())
//                .age(student.getAge())
//                .build();
        studentFromDB.setFirstName(student.getFirstName());
        studentFromDB.setLastName(student.getLastName());
        studentFromDB.setAge(student.getAge());
        studentRepository.save(studentFromDB);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
