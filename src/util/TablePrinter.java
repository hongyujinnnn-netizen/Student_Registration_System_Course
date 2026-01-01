package util;

import model.Course;
import model.Student;

import java.util.List;

public class TablePrinter {

    public static void printCourses(List<Course> courses) {
        System.out.println("+------+----------------------+--------+-------+");
        System.out.println("| ID   | Course Name          | Price  | Seats |");
        System.out.println("+------+----------------------+--------+-------+");

        for (Course c : courses) {
            System.out.printf("| %-4s | %-20s | $%-6.2f | %-5d |\n",
                    c.getCourseId(), c.getCourseName(), c.getPrice(), c.getSeats());
        }
        System.out.println("+------+----------------------+--------+-------+");
    }

    public static void printStudents(List<Student> students) {
        System.out.println("+--------+-----------+--------------------+");
        System.out.println("| ID     | Username  | Email              |");
        System.out.println("+--------+-----------+--------------------+");

        for (Student s : students) {
            System.out.printf("| %-6s | %-9s | %-18s |\n",
                    s.getId(), s.getUsername(), s.getEmail());
        }
        System.out.println("+--------+-----------+--------------------+");
    }
}
