package class_problem;
import java.util.Scanner;
public class one_time_college_setup {
    class SrmStudent {
        String name;
        static String collegeName;
        static String academicYear;

        // Static block executes exactly once when the class is first loaded into memory
        static {
            collegeName = "SRM Institute of Science and Technology";
            academicYear = "2026-2027";
            System.out.println("College info loaded");
        }

        public SrmStudent(String name) {
            this.name = name;
            System.out.println("Student record created: " + this.name);
        }
    }

    public class SrmStudentBatchSetup {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter student names separated by comma: ");
            String line = scanner.nextLine().trim();
            String[] names = line.split(",");

            SrmStudent[] batch = new SrmStudent[names.length];

            for (int i = 0; i < names.length; i++) {
                batch[i] = new SrmStudent(names[i].trim());
            }

            scanner.close();
        }
    }
}

