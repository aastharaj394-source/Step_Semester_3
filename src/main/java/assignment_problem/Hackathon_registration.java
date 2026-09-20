package assignment_problem;
import java.util.Scanner;
public class Hackathon_registration {
    class Participant {
        String name;
        String teamName;
        boolean registered;

        public Participant(String name, String teamName) {
            this.name = name;
            this.teamName = teamName;
            this.registered = true;
        }

        public Participant(String name) {
            this(name, "Unassigned");
        }

        public void printStatus() {
            System.out.println(name + " | " + teamName + " | Registered: " + registered);
        }
    }

    public class ParticipantRegistration {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of participants: ");
            int n = Integer.parseInt(scanner.nextLine().trim());

            String[] names = new String[n];
            String[] teamNames = new String[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter participant name: ");
                names[i] = scanner.nextLine().trim();

                System.out.print("Enter team name (press Enter if solo): ");
                teamNames[i] = scanner.nextLine().trim();
            }

            System.out.println();
            for (int i = 0; i < n; i++) {
                Participant p;
                if (teamNames[i].isEmpty()) {
                    p = new Participant(names[i]);
                } else {
                    p = new Participant(names[i], teamNames[i]);
                }
                p.printStatus();
            }

            scanner.close();
        }
    }
}
