package assignment_problem;
import java.util.Scanner;
public class splitting_employee_class_correctly {
    class CompanyEmployee {
        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public CompanyEmployee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println("Company: " + companyName);
            System.out.println("Total Employees: " + employeeCount);
        }
    }

    public class CompanyStaffTracker {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter 3 employee records (Name, Salary):");
            for (int i = 1; i <= 3; i++) {
                System.out.print("Employee " + i + ": ");
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String name = parts[0].trim();
                double salary = Double.parseDouble(parts[1].trim());

                new CompanyEmployee(name, salary);
            }

            System.out.println("\n--- Static Company Info ---");
            CompanyEmployee.printCompanyInfo();

            scanner.close();
        }
    }
}
