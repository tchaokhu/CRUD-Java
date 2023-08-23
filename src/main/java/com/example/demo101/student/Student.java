package com.example.demo101.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "students")
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Student {
    private UUID id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    public Student(UUID id, String name, String email, LocalDate dob, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }
}
