package assignment_problems;
import java.util.*;

interface MembershipPlan {
    String getName();
    double calculateFee();
}

class MonthlyPlan implements MembershipPlan {
    public String getName() {
        return "Monthly";
    }

    public double calculateFee() {
        return 1000;
    }
}

class QuarterlyPlan implements MembershipPlan {
    public String getName() {
        return "Quarterly";
    }

    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }
}

class AnnualPlan implements MembershipPlan {
    public String getName() {
        return "Annual";
    }

    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }
}

class Member {
    private String name;

    Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Membership {
    private Member member;
    private MembershipPlan plan;
    private String status;

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        this.status = "Active";
    }

    public void display() {
        System.out.println(plan.getName() +
                " membership created for " +
                member.getName() + ".");

        System.out.printf("Fee: ₹%.2f%n", plan.calculateFee());
        System.out.println("Status: " + status);
    }

    public void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member.getName() +
                    " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " +
                    member.getName() +
                    "'s membership is " + status + ".");
        }
    }

    public void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";

            System.out.println(member.getName() +
                    "'s membership frozen.");
            System.out.println("Status: " + status);
        } else if (status.equals("Expired")) {
            System.out.println("Cannot freeze an Expired membership.");
        } else {
            System.out.println("Membership is already Frozen.");
        }
    }

    public void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";

            System.out.println(member.getName() +
                    "'s membership unfrozen.");
            System.out.println("Status: " + status);
        } else if (status.equals("Expired")) {
            System.out.println("Cannot unfreeze an Expired membership.");
        } else {
            System.out.println("Membership is already Active.");
        }
    }

    public void expire() {
        status = "Expired";

        System.out.println(member.getName() +
                "'s membership expired.");
        System.out.println("Status: " + status);
    }
}

public class Main {
    public static MembershipPlan createPlan(String type) {
        if (type.equalsIgnoreCase("Monthly")) {
            return new MonthlyPlan();
        } else if (type.equalsIgnoreCase("Quarterly")) {
            return new QuarterlyPlan();
        } else {
            return new AnnualPlan();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter member name: ");
        String name = sc.nextLine();

        System.out.print("Enter plan (Monthly/Quarterly/Annual): ");
        String planType = sc.nextLine();

        Member member = new Member(name);
        MembershipPlan plan = createPlan(planType);
        Membership membership = new Membership(member, plan);

        membership.display();

        System.out.println("\n1. Check In");
        System.out.println("2. Freeze");
        System.out.println("3. Unfreeze");
        System.out.println("4. Expire");
        System.out.println("5. Exit");

        while (true) {
            System.out.print("\nEnter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                membership.checkIn();
            } else if (choice == 2) {
                membership.freeze();
            } else if (choice == 3) {
                membership.unfreeze();
            } else if (choice == 4) {
                membership.expire();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
