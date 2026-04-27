package com.example.SMS.Entity;

import com.example.SMS.Entity.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  int id;

    @NotBlank(message = "name cannot be empty")
     private String name;

    @Email
    private String email;

    @Min(value = 18)
    private int age;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Course course;

}
