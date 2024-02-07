package com.paychex.testapi.controller;

import com.paychex.testapi.entity.Student;
import com.paychex.testapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> listAll() {
        return ResponseEntity.ok(service.listAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentByStudentid(@PathVariable long id) {
        return ResponseEntity.ok(service.getStudentByStudentid(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getStudentByEmail(email));
    }

    @PostMapping
    public ResponseEntity<Student> postStudent(@RequestBody Student s){
        return ResponseEntity.ok(service.createStudent(s));
    }

    @Transactional
    @PutMapping("/{id}/{pass}")
    public ResponseEntity<String> updatePassword(@PathVariable long id,@PathVariable String pass) {
        return ResponseEntity.ok(service.updatePassword(id, pass));
    }

}
