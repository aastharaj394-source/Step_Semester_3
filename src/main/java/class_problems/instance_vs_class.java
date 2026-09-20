package class_problems;
import java.util.Scanner;
public class instance_vs_class {
    public class Student {
        String name;
        int attendance;

        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        public Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println("College: " + collegeName);
            System.out.println("Total Students Enrolled: " + studentCount);
        }

        public static void main(String[] args) {
            Student s1 = new Student("Ravi", 85);
            Student s2 = new Student("Anitha", 92);

            Student.printCollegeInfo();
        }
    }
}
