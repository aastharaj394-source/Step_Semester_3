package assignment_problem;
import java.util.Scanner;
public class contructor_overloading_employee {
    class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;

        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }
    public class EmployeeSetup {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter permanent employee details (ID, Name, Salary):");
            String permInput = scanner.nextLine().trim();
            String[] permParts = permInput.split(",");
            String pId = permParts[0].trim();
            String pName = permParts[1].trim();
            double pSalary = Double.parseDouble(permParts[2].trim());

            Employee permanentEmp = new Employee(pId, pName, pSalary);

            System.out.println("Enter intern details (ID, Name):");
            String internInput = scanner.nextLine().trim();
            String[] internParts = internInput.split(",");
            String iId = internParts[0].trim();
            String iName = internParts[1].trim();

            Employee internEmp = new Employee(iId, iName);

            System.out.println("\n--- Profiles ---");
            permanentEmp.printProfile();
            internEmp.printProfile();

            scanner.close();
        }
    }


}
