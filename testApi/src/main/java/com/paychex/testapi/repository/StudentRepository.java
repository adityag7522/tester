package com.paychex.testapi.repository;

import com.paychex.testapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByStudentid(long id);
    public Student findByEmail(String email);

    @Query("update Student s set s.password = :pass where s.studentid = :id")
    public int updatePassword(@Param("id") long id, @Param("pass") String pass);
}
