package assignment_problem;
import java.util.Scanner;

abstract class Drone {
    public Drone() {
    }

    public abstract String fly();
}

interface Trackable {
    String getLocation();
}

class DeliveryDrone extends Drone implements Trackable {
    private String id;

    public DeliveryDrone(String id) {
        this.id = id;
    }

    public String fly() {
        return id + " flying for delivery";
    }

    public String getLocation() {
        return id + " at Sector 4";
    }
}

class ScoutDrone extends Drone {
    private String id;

    public ScoutDrone(String id) {
        this.id = id;
    }

    public String fly() {
        return id + " flying for scouting";
    }
}

class GroundRobot implements Trackable {
    private String id;

    public GroundRobot(String id) {
        this.id = id;
    }

    public String getLocation() {
        return id + " at Sector 4";
    }
}

public class Main {
    static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            Trackable t = (Trackable) o;
            return t.getLocation();
        }

        return "Tracking not available";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Delivery Drone");
        System.out.println("2. Scout Drone");
        System.out.println("3. Ground Robot");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        Object object;

        if (choice == 1) {
            object = new DeliveryDrone(id);
        } else if (choice == 2) {
            object = new ScoutDrone(id);
        } else if (choice == 3) {
            object = new GroundRobot(id);
        } else {
            System.out.println("Invalid choice");
            return;
        }

        System.out.println(getLocationIfTrackable(object));
    }
}