package com.example.SMS.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {

    private Integer id;  // --> for response

    private String name;

    private String email;

    private int age;

    private int courseId;// -->for request

    private String courseName;//-->for response

}
