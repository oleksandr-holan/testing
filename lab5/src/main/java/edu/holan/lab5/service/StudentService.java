package edu.holan.lab5.service;

/*
    @author joert
    @project lab5
    @since 12.04.2025 - 17.32
*/

import edu.holan.lab5.model.Student;
import edu.holan.lab5.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    private final List<Student> students = new ArrayList<>();
    {
        students.add(new Student("1", "John Doe", "A-101", 1));
        students.add(new Student("2", "Jane Smith", "B-202", 2));
        students.add(new Student("3", "Bob Johnson", "C-303", 3));
    }

    @PostConstruct
    void init() {
        studentRepository.saveAll(students);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // CRUD operations

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(String id, Student studentDetails) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student existingStudent = student.get();
            existingStudent.setName(studentDetails.getName());
            existingStudent.setGroup(studentDetails.getGroup());
            existingStudent.setCourse(studentDetails.getCourse());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}