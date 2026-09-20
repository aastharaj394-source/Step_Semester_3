package assignment_problem;
import java.util.Scanner;
public class The_Monthly_Attendance_Announcer {
    class AnnounceMember {
        protected String memberId;
        protected int monthlyFee;
        protected int sessionsAttended;

        public AnnounceMember(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }

        public String displayInfo() {
            return "Standard | Sessions: " + this.sessionsAttended;
        }
    }

    class AnnouncePremiumMember extends AnnounceMember {
        private String trainerName;

        public AnnouncePremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        public String getTrainerName() {
            return this.trainerName;
        }

        @Override
        public String displayInfo() {
            return "Premium | Trainer: " + this.trainerName + " | Sessions: " + this.sessionsAttended;
        }
    }

    public class AttendanceAnnouncer {

        public static String batchPrint(AnnounceMember[] members) {
            StringBuilder sb = new StringBuilder();

            for (AnnounceMember m : members) {
                sb.append(m.displayInfo());

                if (m instanceof AnnouncePremiumMember) {
                    AnnouncePremiumMember pm = (AnnouncePremiumMember) m;
                    sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
                }

                sb.append(" | ");
            }

            return sb.toString();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            AnnounceMember[] members = new AnnounceMember[n];

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String type = parts[0].trim();
                String id = parts[1].trim();
                int fee = Integer.parseInt(parts[2].trim());

                if (type.equalsIgnoreCase("Premium")) {
                    String trainer = parts[3].trim();
                    members[i] = new AnnouncePremiumMember(id, fee, trainer);
                } else {
                    members[i] = new AnnounceMember(id, fee);
                }
            }

            System.out.println(batchPrint(members));

            scanner.close();
        }
    }
}
