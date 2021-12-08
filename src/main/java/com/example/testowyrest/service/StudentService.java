package com.example.testowyrest.service;

import com.example.testowyrest.entity.Student;

import java.util.List;

public interface StudentService {

    Student getStudent(Long id);
    List<Student> getAllStudent();
    void create(Student student);
    void update(Long id, Student student);
    void delete(Long id);
}
