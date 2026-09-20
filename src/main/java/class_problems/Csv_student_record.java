package class_problems;
import java.util.Scanner;
public class Csv_student_record {
        public static void parseStudentRecord(String csvLine) {
            if (csvLine == null) {
                System.out.println("Invalid Record");
                return;
            }
            String[] fields = csvLine.split(",");
            if (fields.length != 3) {
                System.out.println("Invalid Record");
                return;
            }
            String name = fields[0].trim();
            String rollNumber = fields[1].trim();
            String department = fields[2].trim();
            if (name.isEmpty() || rollNumber.isEmpty() || department.isEmpty()) {
                System.out.println("Invalid Record");
                return;
            }
            System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
        }
        public static void main(String[]args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student record (CSV format: Name,RollNumber,Department): ");
            String line = scanner.nextLine();
            parseStudentRecord(line);
            scanner.close();
        }
}
