package assignment_problem;
import java.util.Scanner;
public class Gym_Membership_Foundation {
    class GymMember {
        protected String memberId;
        protected int monthlyFee;
        protected int sessionsAttended;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid memberId: must be non-blank and at least 4 characters");
            }
            this.memberId = memberId.trim();
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }

        public void attendSession() {
            this.sessionsAttended++;
        }

        public int getSessionsAttended() {
            return this.sessionsAttended;
        }

        public static String signUpBatch(String[] memberIds, int monthlyFee) {
            int signedUp = 0;
            int rejected = 0;

            for (String id : memberIds) {
                try {
                    new GymMember(id, monthlyFee);
                    signedUp++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
            return "Signed Up: " + signedUp + " | Rejected: " + rejected;
        }
    }

    class PremiumMember extends GymMember {
        protected String trainerName;

        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        public String getTrainerName() {
            return this.trainerName;
        }
    }

    public class GymBatchSignup {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int fee = Integer.parseInt(scanner.nextLine().trim());
            int n = Integer.parseInt(scanner.nextLine().trim());

            String[] ids = new String[n];
            for (int i = 0; i < n; i++) {
                ids[i] = scanner.nextLine();
            }

            System.out.println(GymMember.signUpBatch(ids, fee));

            scanner.close();
        }
    }
}
