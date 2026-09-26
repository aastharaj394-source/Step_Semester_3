package assignment_problems;
import java.util.*;
import java.util.*;

interface WashType {
    String getName();
    int getDuration();
    double getCharge();
}

class QuickWash implements WashType {
    public String getName() {
        return "Quick";
    }

    public int getDuration() {
        return 30;
    }

    public double getCharge() {
        return 20;
    }
}

class NormalWash implements WashType {
    public String getName() {
        return "Normal";
    }

    public int getDuration() {
        return 45;
    }

    public double getCharge() {
        return 30;
    }
}

class HeavyWash implements WashType {
    public String getName() {
        return "Heavy";
    }

    public int getDuration() {
        return 60;
    }

    public double getCharge() {
        return 45;
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

class WashCycle {
    private Student student;
    private WashingMachine machine;
    private WashType washType;

    WashCycle(Student student, WashingMachine machine, WashType washType) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    public void display() {
        System.out.println(washType.getName() + " wash started on " +
                machine.getId() + " for " + student.getName() +
                " (" + washType.getDuration() + " min).");
        System.out.printf("Charge: ₹%.2f%n", washType.getCharge());
    }
}

class WashingMachine {
    private String id;
    private boolean busy;

    WashingMachine(String id) {
        this.id = id;
        this.busy = false;
    }

    public String getId() {
        return id;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startWash(Student student, WashType washType) {
        if (busy) {
            System.out.println("Machine " + id + " is currently busy.");
            return;
        }

        busy = true;

        WashCycle cycle = new WashCycle(student, this, washType);
        cycle.display();
    }

    public void completeWash() {
        if (busy) {
            busy = false;
            System.out.println("M1 cycle completed.");
            System.out.println(id + " is now free.");
        } else {
            System.out.println(id + " is already free.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        System.out.print("Enter student name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter wash type (Quick/Normal/Heavy): ");
        String type1 = sc.nextLine();

        Student student1 = new Student(name1);
        WashType wash1;

        if (type1.equalsIgnoreCase("Quick")) {
            wash1 = new QuickWash();
        } else if (type1.equalsIgnoreCase("Normal")) {
            wash1 = new NormalWash();
        } else {
            wash1 = new HeavyWash();
        }

        m1.startWash(student1, wash1);

        System.out.print("Enter second student name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter wash type (Quick/Normal/Heavy): ");
        String type2 = sc.nextLine();

        Student student2 = new Student(name2);
        WashType wash2;

        if (type2.equalsIgnoreCase("Quick")) {
            wash2 = new QuickWash();
        } else if (type2.equalsIgnoreCase("Normal")) {
            wash2 = new NormalWash();
        } else {
            wash2 = new HeavyWash();
        }

        m1.startWash(student2, wash2);

        m2.startWash(student2, new HeavyWash());

        m1.completeWash();

        System.out.print("Enter third student name: ");
        String name3 = sc.nextLine();

        Student student3 = new Student(name3);

        m1.startWash(student3, new NormalWash());

        sc.close();
    }
}
