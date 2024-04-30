package com.example.demo101.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student createStudent(String name,String email, Integer age){
        UUID studentId = UUID.randomUUID();
        Student student = studentRepository.save(new Student(
                studentId,
                name,
                email,
                LocalDate.of(2000, Month.JANUARY,5),
                age
        ));
        return student;
    }

//    public Student updateStudent(UUID id,String name,String email, Integer age){
//
//    }

    public List<Student> findALlStudent(){
        return studentRepository.findAll();
    }

    public Optional<Student> findById(UUID id){
        return studentRepository.findStudentById(id);
    }

    public void deleteStudentById(UUID id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(UUID id, Student updatedStudent) {
        // Check if the student with the given ID exists
        Student existingStudent = studentRepository.findStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));

        // Update the properties of the existing student with the values from updatedStudent
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDob(updatedStudent.getDob());
        existingStudent.setAge(updatedStudent.getAge());

        // Save the updated student
        return studentRepository.save(existingStudent);
    }
}
