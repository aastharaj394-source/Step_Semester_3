package assignment_problem;
import java.util.Scanner;
public class Membership_Numbers_Referral_Codes {
    class SettlementGymMember {
        private static int counter = 2000;
        private static int membersEnrolled = 0;

        public final String membershipNumber;
        private int feesPaid;

        public SettlementGymMember(int monthlyFee) {
            counter++;
            membersEnrolled++;
            this.membershipNumber = "GYM-" + counter;
            this.feesPaid = 0;
        }

        public static int getMembersEnrolled() {
            return membersEnrolled;
        }

        public void payFee(int amount) {
            this.feesPaid += amount;
        }

        public void payFee(int amount, String mode) {
            payFee(amount);
        }

        public int getFeesPaid() {
            return this.feesPaid;
        }

        public static boolean isValidReferralCode(String code) {
            if (code == null || code.length() != 4) {
                return false;
            }
            if (code.charAt(0) != 'G') {
                return false;
            }
            if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
                return false;
            }
            if (!Character.isUpperCase(code.charAt(3)) || !Character.isLetter(code.charAt(3))) {
                return false;
            }
            return true;
        }
    }

    class SettlementGroupClassMember extends SettlementGymMember {
        private String className;

        public SettlementGroupClassMember(int monthlyFee, String className) {
            super(monthlyFee);
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public class WeeklySettlementProcessor {

        public static String processWeeklyCheckIn(SettlementGymMember[] members) {
            int processed = 0;
            int skipped = 0;
            int group = 0;
            int individual = 0;

            if (members != null) {
                for (SettlementGymMember m : members) {
                    if (m == null) {
                        skipped++;
                    } else {
                        processed++;
                        if (m instanceof SettlementGroupClassMember) {
                            group++;
                        } else {
                            individual++;
                        }
                    }
                }
            }

            return processed + " processed | " + skipped + " null skipped | " + group + " group | " + individual + " individual";
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int refCount = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < refCount; i++) {
                String code = scanner.nextLine().trim();
                System.out.println(SettlementGymMember.isValidReferralCode(code));
            }

            int memberCount = Integer.parseInt(scanner.nextLine().trim());
            SettlementGymMember[] members = new SettlementGymMember[memberCount];

            for (int i = 0; i < memberCount; i++) {
                String line = scanner.nextLine().trim();
                if (line.equalsIgnoreCase("null")) {
                    members[i] = null;
                } else {
                    String[] parts = line.split(",");
                    String type = parts[0].trim();
                    int fee = Integer.parseInt(parts[1].trim());

                    if (type.equalsIgnoreCase("Group")) {
                        String className = parts[2].trim();
                        members[i] = new SettlementGroupClassMember(fee, className);
                    } else {
                        members[i] = new SettlementGymMember(fee);
                    }
                }
            }

            System.out.println(processWeeklyCheckIn(members));

            scanner.close();
        }
    }
}
