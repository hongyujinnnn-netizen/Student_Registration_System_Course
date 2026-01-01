package service.impl;

import model.Student;
import service.StudentService;

import java.util.*;

public class StudentServiceImpl implements StudentService {

    private final List<Student> students = new ArrayList<>();

    @Override
    public void signUp(Student student) {
        students.add(student);
    }

    @Override
    public Student login(String username, String password) {
        for (Student s : students) {
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public void deleteStudent(String studentId) {
        students.removeIf(s -> s.getId().equals(studentId));
    }
}
