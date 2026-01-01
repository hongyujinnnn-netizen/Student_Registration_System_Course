package service;

import model.Course;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    void deleteCourse(String courseId);
    List<Course> getAllCourses();
    Course findById(String courseId);
}
