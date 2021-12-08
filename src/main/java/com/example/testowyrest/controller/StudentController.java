package com.example.testowyrest.controller;

import com.example.testowyrest.entity.Student;
import com.example.testowyrest.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.create(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable("id") Long id){
        studentService.delete(id);
    }
}
