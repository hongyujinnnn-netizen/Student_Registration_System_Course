import model.Course;
import model.Registration;
import model.Student;
import service.CourseService;
import service.RegistrationService;
import service.StudentService;
import service.impl.CourseServiceImpl;
import service.impl.RegistrationServiceImpl;
import service.impl.StudentServiceImpl;
import util.TablePrinter;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static StudentService studentService = new StudentServiceImpl();
    static CourseService courseService = new CourseServiceImpl();
    static RegistrationService registrationService = new RegistrationServiceImpl();

    static void initDefaultCourses() {
        courseService.addCourse(new Course(
                IdGenerator.generateCourseId(),
                "Java Programming",
                120.0,
                30
        ));

        courseService.addCourse(new Course(
                IdGenerator.generateCourseId(),
                "Web Development",
                150.0,
                25
        ));

        courseService.addCourse(new Course(
                IdGenerator.generateCourseId(),
                "Database System",
                100.0,
                20
        ));

        courseService.addCourse(new Course(
                IdGenerator.generateCourseId(),
                "Data Structures",
                130.0,
                15
        ));
    }


    public static void main(String[] args) {

        initDefaultCourses();
        while (true) {
            System.out.println("\n===== STUDENT COURSE SYSTEM =====");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) signUp();
            else if (choice == 2) login();
            else break;
        }
    }

    static void signUp() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Student student = new Student(
                IdGenerator.generateStudentId(),
                username,
                password,
                email
        );

        studentService.signUp(student);
        System.out.println("✅ Sign up success. Your ID: " + student.getId());
    }

    static void login() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if (username.equals("admin") && password.equals("admin123")) {
            adminMenu();
            return;
        }

        Student student = studentService.login(username, password);
        if (student != null) userMenu(student);
        else System.out.println("❌ Login failed");
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\n===== ADMIN DASHBOARD =====");
            System.out.println("1. Add Course");
            System.out.println("2. Delete Course");
            System.out.println("3. View Courses");
            System.out.println("4. View Students");
            System.out.println("5. View Registrations");
            System.out.println("0. Logout");
            System.out.print("Choose: ");

            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Course name: ");
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Seats: ");
                int seats = sc.nextInt();

                Course c = new Course(
                        IdGenerator.generateCourseId(),
                        name, price, seats
                );
                courseService.addCourse(c);
            }
            else if (ch == 2) {
                System.out.print("Course ID: ");
                courseService.deleteCourse(sc.nextLine());
            }
            else if (ch == 3)
                TablePrinter.printCourses(courseService.getAllCourses());
            else if (ch == 4)
                TablePrinter.printStudents(studentService.getAllStudents());
            else if (ch == 5)
                System.out.println(registrationService.getAll());
            else break;
        }
    }

    static void userMenu(Student student) {
        while (true) {
            System.out.println("\n===== USER MENU =====");
            System.out.println("1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. My Courses");
            System.out.println("0. Logout");
            System.out.print("Choose: ");

            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1)
                TablePrinter.printCourses(courseService.getAllCourses());
            else if (ch == 2) {
                System.out.print("Course ID: ");
                String id = sc.nextLine();
                Course c = courseService.findById(id);

                if (c != null) {
                    registrationService.register(
                            new Registration(
                                    student.getId(),
                                    c.getCourseId(),
                                    c.getPrice(),
                                    LocalDate.now()
                            )
                    );
                    System.out.println("✅ Registered successfully");
                }
            }
            else if (ch == 3)
                System.out.println(registrationService.getByStudent(student.getId()));
            else break;
        }
    }
}
