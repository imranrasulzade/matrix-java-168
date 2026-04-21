package com.example.matrix168.controller;

import com.example.matrix168.model.Student;
import com.example.matrix168.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentRepository studentRepository;

    StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Integer id){
        return studentRepository.findById(id);
    }
}
