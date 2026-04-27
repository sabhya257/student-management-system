package com.example.SMS.Mapper;

import com.example.SMS.DTO.StudentDTO;
import com.example.SMS.Entity.Course;
import com.example.SMS.Entity.Student;

public class StudentMapper {

    // ENTITY → DTO
    public static StudentDTO toDTO(Student student) {

        StudentDTO dto = new StudentDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());

        if (student.getCourse() != null) {
            dto.setCourseId(student.getCourse().getId());
            dto.setCourseName(student.getCourse().getCourseName());
        }

        return dto;
    }

    // DTO → ENTITY
    public static Student toEntity(StudentDTO dto, Course course) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());
        student.setCourse(course);

        return student;
    }
}
