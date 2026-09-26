package class_problems;
import java.util.*;

interface LeavePolicy {
    boolean isLeaveAllowed(int days);
}

class FullTimePolicy implements LeavePolicy {
    public boolean isLeaveAllowed(int days) {
        return days <= 30;
    }
}

class PartTimePolicy implements LeavePolicy {
    public boolean isLeaveAllowed(int days) {
        return days <= 15;
    }
}

class ContractorPolicy implements LeavePolicy {
    public boolean isLeaveAllowed(int days) {
        return days <= 10;
    }
}

abstract class Employee {
    protected String name;
    protected LeavePolicy policy;

    Employee(String name, LeavePolicy policy) {
        this.name = name;
        this.policy = policy;
    }

    public String getName() {
        return name;
    }

    public boolean canTakeLeave(int days) {
        return policy.isLeaveAllowed(days);
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name, new FullTimePolicy());
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name, new PartTimePolicy());
    }
}

class Contractor extends Employee {
    Contractor(String name) {
        super(name, new ContractorPolicy());
    }
}

class LeaveRequest {
    private Employee employee;
    private String startDate;
    private String endDate;
    private int days;
    private String status;

    LeaveRequest(Employee employee, String startDate, String endDate, int days) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
        this.status = "Pending";
    }

    public void submit() {
        if (!employee.canTakeLeave(days)) {
            System.out.println("Leave request rejected by leave policy.");
            return;
        }

        System.out.println("Leave request submitted for " +
                employee.getName() +
                " (" + startDate + "-" + endDate + ").");

        System.out.println("Status: " + status);
    }

    public void approve() {
        if (!status.equals("Pending")) {
            System.out.println("Cannot approve. Status is already " + status + ".");
            return;
        }

        status = "Approved";

        System.out.println(employee.getName() +
                "'s leave request (" +
                startDate + "-" + endDate +
                ") approved.");

        System.out.println("Status: " + status);
    }

    public void reject() {
        if (!status.equals("Pending")) {
            System.out.println("Cannot reject. Status is already " + status + ".");
            return;
        }

        status = "Rejected";

        System.out.println(employee.getName() +
                "'s leave request (" +
                startDate + "-" + endDate +
                ") rejected.");

        System.out.println("Status: " + status);
    }

    public void changeToPending() {
        if (status.equals("Pending")) {
            System.out.println("Request is already Pending.");
        } else {
            System.out.println("Cannot change leave request status from " +
                    status + " to Pending.");
        }
    }
}

public class Main {
    public static Employee createEmployee(String type, String name) {
        if (type.equalsIgnoreCase("FullTime")) {
            return new FullTimeEmployee(name);
        } else if (type.equalsIgnoreCase("PartTime")) {
            return new PartTimeEmployee(name);
        } else {
            return new Contractor(name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter employee type (FullTime/PartTime/Contractor): ");
        String type = sc.nextLine();

        System.out.print("Enter start date: ");
        String startDate = sc.nextLine();

        System.out.print("Enter end date: ");
        String endDate = sc.nextLine();

        System.out.print("Enter number of leave days: ");
        int days = sc.nextInt();

        Employee employee = createEmployee(type, name);

        LeaveRequest request =
                new LeaveRequest(employee, startDate, endDate, days);

        request.submit();

        System.out.println("1. Approve");
        System.out.println("2. Reject");

        System.out.print("Enter review choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            request.approve();
        } else if (choice == 2) {
            request.reject();
        }

        System.out.print("Do you want to change status to Pending? (yes/no): ");
        sc.nextLine();
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            request.changeToPending();
        }

        sc.close();
    }
}
