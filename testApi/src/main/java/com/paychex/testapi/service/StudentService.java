package com.paychex.testapi.service;

import com.paychex.testapi.entity.Student;
import com.paychex.testapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<Student> listAllStudents() {
        return repo.findAll();
    }

    public Student getStudentByStudentid(long id) {
        return repo.findByStudentid(id);
    }

    public Student getStudentByEmail(String email) {
        return repo.findByEmail(email);
    }

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public String updatePassword(long id, String pass) {
        int res = repo.updatePassword(id, pass);
        if(res > 0) {
            return "Password Updated Successfully";
        }
        return "Password Updation Failed";
    }

}
