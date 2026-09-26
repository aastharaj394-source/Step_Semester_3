package assignment_problem;
import java.util.Scanner;

interface Ringable {
    String ring();
}

class AlarmClock implements Ringable {
    private String time;

    public AlarmClock(String time) {
        this.time = time;
    }

    public String ring() {
        return "Alarm ringing for " + time;
    }
}

class Doorbell implements Ringable {
    private String location;

    public Doorbell(String location) {
        this.location = location;
    }

    public String ring() {
        return "Doorbell ringing at " + location;
    }
}

public class Main {
    static void ringAll(Ringable[] devices) {
        for (Ringable device : devices) {
            System.out.println(device.ring());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter alarm time: ");
        String time = sc.nextLine();

        System.out.print("Enter doorbell location: ");
        String location = sc.nextLine();

        AlarmClock a = new AlarmClock(time);
        Doorbell d = new Doorbell(location);

        System.out.println(a.ring());
        System.out.println(d.ring());

        Ringable[] devices = {a, d};

        System.out.println("All devices:");
        ringAll(devices);
    }
}
