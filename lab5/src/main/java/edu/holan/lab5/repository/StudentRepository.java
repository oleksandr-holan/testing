package edu.holan.lab5.repository;

/*
    @author joert
    @project lab5
    @since 12.04.2025 - 17.30
*/

import edu.holan.lab5.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}

