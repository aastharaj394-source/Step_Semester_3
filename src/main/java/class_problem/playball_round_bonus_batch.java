package class_problem;
import java.util.Scanner;
public class playball_round_bonus_batch {
    class Employee {
        String empId;
        double salary;

        // Resolving field/parameter clash using this
        public Employee(String empId, double salary) {
            this.empId = empId;
            this.salary = salary;
        }

        // Resolving parameter clash using this
        public void raiseSalary(double salary) {
            this.salary += salary;
        }

        public void printSummary() {
            System.out.println(this.empId + " | Final Salary: Rs " + this.salary);
        }
    }

    public class PayrollBatchBonus {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of employees: ");
            int count = Integer.parseInt(scanner.nextLine().trim());

            Employee[] employees = new Employee[count];

            for (int i = 0; i < count; i++) {
                System.out.print("Enter Employee ID and Starting Salary (e.g., E-101, 40000): ");
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String id = parts[0].trim();
                double salary = Double.parseDouble(parts[1].trim());

                employees[i] = new Employee(id, salary);
            }

            System.out.print("\nEnter festival bonus amount to apply to all: ");
            double bonus = Double.parseDouble(scanner.nextLine().trim());

            System.out.println("\n--- Updated Payroll Records ---");
            for (Employee emp : employees) {
                emp.raiseSalary(bonus);
                emp.printSummary();
            }

            scanner.close();
        }
    }
}
