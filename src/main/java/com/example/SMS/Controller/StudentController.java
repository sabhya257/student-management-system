//package com.example.SMS.Controller;
//
//import com.example.SMS.DTO.StudentDTO;
//import com.example.SMS.Entity.Student;
//import com.example.SMS.Service.StudentService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/student")
//public class StudentController {
//
//    @Autowired
//    StudentService studentService;
//
//    @PostMapping
//    public ResponseEntity<StudentDTO> saveStudent(@Valid  @RequestBody StudentDTO studentDTO){
//    Student student = studentService.saveStudent(studentDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(studentDTO);
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<Student>> getStudents(Pageable pageable){
//
//        Page<Student> students = studentService.getStudents(pageable);
//
//        return ResponseEntity.ok(students);
//    }
////    @GetMapping
////    public ResponseEntity<List<Student>> getAllStudents(){
////        return ResponseEntity.ok(studentService.getAllStudents());
////    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> findStudentById(@PathVariable int id){
//        Student student = studentService.getStudentById(id);
//        return ResponseEntity.ok(student);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO){
//    Student updatedStudent = studentService.updateStudent(id,studentDTO);
//    return ResponseEntity.ok(updatedStudent);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
//        studentService.deleteStudent(id);
//        return ResponseEntity.noContent().build();
//    }
//
//}
