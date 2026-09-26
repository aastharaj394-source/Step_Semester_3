package assignment_problems;
import java.util.*;
import java.util.*;

abstract class Assignment {
    protected String title;
    protected double maxMarks;
    protected int dueDay;

    Assignment(String title, double maxMarks, int dueDay) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDay = dueDay;
    }

    public String getTitle() {
        return title;
    }

    public double getMaxMarks() {
        return maxMarks;
    }

    public int getLateDays(int submissionDay) {
        return Math.max(0, submissionDay - dueDay);
    }

    public abstract double calculateFinalMarks(double awardedMarks, int lateDays);
}

class CodingAssignment extends Assignment {
    CodingAssignment(String title, double maxMarks, int dueDay) {
        super(title, maxMarks, dueDay);
    }

    public double calculateFinalMarks(double awardedMarks, int lateDays) {
        double penalty = lateDays * 10;
        return Math.max(0, awardedMarks * (1 - penalty / 100));
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String title, double maxMarks, int dueDay) {
        super(title, maxMarks, dueDay);
    }

    public double calculateFinalMarks(double awardedMarks, int lateDays) {
        double penalty = lateDays * 20;
        return Math.max(0, awardedMarks * (1 - penalty / 100));
    }
}

class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Submission {
    private Student student;
    private Assignment assignment;
    private int submissionDay;
    private String status;
    private double finalMarks;

    Submission(Student student, Assignment assignment) {
        this.student = student;
        this.assignment = assignment;
        this.status = "Not Submitted";
    }

    public void submit(int day) {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" +
                    assignment.getTitle() + "' has already been graded.");
            return;
        }

        submissionDay = day;
        status = "Submitted";

        int lateDays = assignment.getLateDays(day);

        if (lateDays == 0) {
            System.out.println(student.getName() + "'s submission for '" +
                    assignment.getTitle() + "' received (on time).");
        } else {
            System.out.println(student.getName() + "'s submission for '" +
                    assignment.getTitle() + "' received (" +
                    lateDays + " days late).");
        }

        System.out.println("Status: " + status);
    }

    public void grade(double awardedMarks) {
        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade. Assignment has not been submitted.");
            return;
        }

        int lateDays = assignment.getLateDays(submissionDay);

        finalMarks = assignment.calculateFinalMarks(awardedMarks, lateDays);
        status = "Graded";

        System.out.printf("%s graded: %.0f/%.0f.%n",
                student.getName(),
                finalMarks,
                assignment.getMaxMarks());

        if (lateDays > 0) {
            double penalty = assignment instanceof CodingAssignment
                    ? lateDays * 10
                    : lateDays * 20;

            System.out.printf("After %.0f%% late penalty.%n", penalty);
        }

        System.out.println("Status: " + status);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name for coding assignment: ");
        String name1 = sc.nextLine();

        System.out.print("Enter coding assignment title: ");
        String title1 = sc.nextLine();

        System.out.print("Enter maximum marks: ");
        double max1 = sc.nextDouble();

        System.out.print("Enter due day: ");
        int due1 = sc.nextInt();

        System.out.print("Enter submission day: ");
        int submit1 = sc.nextInt();

        System.out.print("Enter awarded marks: ");
        double marks1 = sc.nextDouble();
        sc.nextLine();

        Student student1 = new Student(name1);
        Assignment coding = new CodingAssignment(title1, max1, due1);
        Submission submission1 = new Submission(student1, coding);

        submission1.submit(submit1);
        submission1.grade(marks1);

        System.out.print("\nEnter student name for written assignment: ");
        String name2 = sc.nextLine();

        System.out.print("Enter written assignment title: ");
        String title2 = sc.nextLine();

        System.out.print("Enter maximum marks: ");
        double max2 = sc.nextDouble();

        System.out.print("Enter due day: ");
        int due2 = sc.nextInt();

        System.out.print("Enter submission day: ");
        int submit2 = sc.nextInt();

        System.out.print("Enter awarded marks: ");
        double marks2 = sc.nextDouble();

        Student student2 = new Student(name2);
        Assignment written = new WrittenAssignment(title2, max2, due2);
        Submission submission2 = new Submission(student2, written);

        submission2.submit(submit2);
        submission2.grade(marks2);

        System.out.println("\nAttempting resubmission:");
        submission1.submit(submit1 + 1);

        sc.close();
    }
}