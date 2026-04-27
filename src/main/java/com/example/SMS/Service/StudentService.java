package com.example.SMS.Service;

import com.example.SMS.DTO.StudentDTO;
import com.example.SMS.Entity.Course;
import com.example.SMS.Entity.Student;
import com.example.SMS.Repository.CourseRepository;
import com.example.SMS.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public Student saveStudent(StudentDTO dto) {

        if(studentRepository.existsByNameAndEmail(dto.getName(), dto.getEmail())){
            throw new RuntimeException("Student with same name and email already exists");
        }

        Course course = courseRepository.findById(dto.getCourseId()).orElseThrow(() -> new RuntimeException("course not found"));

        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());
        student.setCourse(course);

        return studentRepository.save(student);
    }

    public Page<Student> getStudents(Pageable pageable) {

        return studentRepository.findAll(pageable);
    }
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
    }
    public Student updateStudent(Integer id, StudentDTO studentDTO){

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(studentDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        existingStudent.setName(studentDTO.getName());
        existingStudent.setEmail(studentDTO.getEmail());
        existingStudent.setAge(studentDTO.getAge());
        existingStudent.setCourse(course);

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(int id){

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }

    public List<Student> searchStudents(String name){
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Student> searchByCourse(String course){
        return studentRepository.findByCourse_CourseName(course);
    }
}

