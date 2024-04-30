package com.example.demo101.student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {
    void deleteById(UUID id);
    Optional<Student> findStudentById(UUID id);

}