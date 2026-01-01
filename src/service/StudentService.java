package service;

import model.Student;

import java.util.List;

public interface StudentService {
    void signUp(Student student);
    Student login(String username, String password);
    List<Student> getAllStudents();
    void deleteStudent(String studentId);
}
