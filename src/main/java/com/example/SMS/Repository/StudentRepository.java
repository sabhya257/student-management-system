package com.example.SMS.Repository;

import com.example.SMS.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    boolean existsByEmail(String email);
    boolean existsByNameAndEmail(String name,String Email);

    //search API
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findByCourse_CourseName(String courseName);}
