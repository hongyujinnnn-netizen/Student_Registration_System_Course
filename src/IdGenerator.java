public class IdGenerator {
    private static int studentCounter = 1000;
    private static int courseCounter = 200;

    public static String generateStudentId() {
        return "STU-" + studentCounter++;
    }

    public static String generateCourseId() {
        return "C-" + courseCounter++;
    }
}
