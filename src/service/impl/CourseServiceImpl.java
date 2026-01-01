package service.impl;

import model.Course;
import service.CourseService;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {


    private final List<Course> courses = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        courses.removeIf(c -> c.getCourseId().equals(courseId));
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public Course findById(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                return c;
            }
        }
        return null;
    }
}
