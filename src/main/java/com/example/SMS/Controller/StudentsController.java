package com.example.SMS.Controller;
import org.springdoc.core.annotations.ParameterObject;
import com.example.SMS.DTO.StudentDTO;
import com.example.SMS.Entity.Student;
import com.example.SMS.Response.ApiResponse;
import com.example.SMS.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentsController {
    
    @Autowired
    StudentService studentService;

    @PostMapping 
 public ResponseEntity<ApiResponse<Student>> saveStudent(@Valid @RequestBody StudentDTO studentDTO){
     Student student = studentService.saveStudent(studentDTO);

     ApiResponse<Student>response = new ApiResponse<>(201,"Student created successfully",student);

     return ResponseEntity.status(HttpStatus.CREATED).body(response);
 }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Student>>> getStudents(@ParameterObject Pageable pageable) {

        Page<Student> students = studentService.getStudents(pageable);

        ApiResponse<Page<Student>> response =
                new ApiResponse<>(200, "Students fetched successfully", students);

        return ResponseEntity.ok(response);
    }

 @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentsById(@PathVariable int id){

     Student student = studentService.getStudentById(id);

     ApiResponse<Student> response = new ApiResponse<>(200,"Student fetched Successfully",student);

     return ResponseEntity.ok(response);
 }

 @PutMapping("/{id}")
public ResponseEntity<ApiResponse<Student>> updateStudent(@Valid @PathVariable int id, @RequestBody StudentDTO studentDTO){

     Student updatedStudent = studentService.updateStudent(id,studentDTO);

 ApiResponse<Student> response = new ApiResponse<>(200,"Student updated successfully",updatedStudent);

 return ResponseEntity.ok(response);
 }

 //search API
 @GetMapping("/search")
 public ResponseEntity<ApiResponse<List<Student>>> searchStudents(@RequestParam String name){

        List<Student> students = studentService.searchStudents(name);
        ApiResponse<List<Student>> response = new ApiResponse<>(200,"students fetched succesfully",students);

        return  ResponseEntity.ok(response);
 }

 //filter API
    @GetMapping("/course")
    public ResponseEntity<ApiResponse<List<Student>>> searchStudentsByCourse(@RequestParam String course){

        List<Student> students = studentService.searchByCourse(course);
      ApiResponse<List<Student>> response = new ApiResponse<>(200,"Student fetched succesfully",students);

      return ResponseEntity.ok(response);
    }

 @DeleteMapping("/{id}")
public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable int id){
     studentService.deleteStudent(id);

     ApiResponse<String> response = new ApiResponse<>(200,"Student deleted successfully",null);
     return ResponseEntity.ok(response);
 }
}
