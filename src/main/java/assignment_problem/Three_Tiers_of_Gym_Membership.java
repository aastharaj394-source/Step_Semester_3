package assignment_problem;
import java.util.Scanner;
public class Three_Tiers_of_Gym_Membership {
    class GymMemberTier {
        protected String memberId;
        protected int monthlyFee;
        protected int sessionsAttended;

        public GymMemberTier(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }

        public void attendSession() {
            this.sessionsAttended++;
        }

        public int getSessionsAttended() {
            return this.sessionsAttended;
        }

        public String displayInfo() {
            return "Standard Member | Sessions: " + this.sessionsAttended;
        }
    }

    class PremiumMemberTier extends GymMemberTier {
        protected String trainerName;

        public PremiumMemberTier(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        @Override
        public String displayInfo() {
            return "Premium Member | Trainer: " + this.trainerName + " | Sessions: " + this.sessionsAttended;
        }
    }

    class EliteMember extends PremiumMemberTier {
        private String lockerNumber;

        public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
            super(memberId, monthlyFee, trainerName);
            this.lockerNumber = lockerNumber;
        }

        @Override
        public String displayInfo() {
            return "Elite Member | Trainer: " + this.trainerName + " | Locker: " + this.lockerNumber + " | Sessions: " + this.sessionsAttended;
        }
    }

    class GroupClassMemberTier extends GymMemberTier {
        private String className;

        public GroupClassMemberTier(String memberId, int monthlyFee, String className) {
            super(memberId, monthlyFee);
            this.className = className;
        }

        @Override
        public String displayInfo() {
            return "Group Class Member | Class: " + this.className + " | Sessions: " + this.sessionsAttended;
        }
    }

    public class GymHierarchyDemo {

        public static String classifyGeneration(GymMemberTier member) {
            if (member instanceof EliteMember) {
                return "Multilevel descendant (3 generations deep)";
            } else if (member instanceof GroupClassMemberTier) {
                return "Hierarchical sibling (independent branch)";
            } else if (member instanceof PremiumMemberTier) {
                return "Direct subclass (2 generations deep)";
            } else {
                return "Base class";
            }
        }

        public static int getTotalSessionsAttended(GymMemberTier[] members) {
            int total = 0;
            for (GymMemberTier m : members) {
                if (m != null) {
                    total += m.getSessionsAttended();
                }
            }
            return total;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            GymMemberTier[] list = new GymMemberTier[n];

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String type = parts[0].trim();
                String id = parts[1].trim();
                int fee = Integer.parseInt(parts[2].trim());
                int sessions = Integer.parseInt(parts[3].trim());

                GymMemberTier member;
                if (type.equalsIgnoreCase("Elite")) {
                    member = new EliteMember(id, fee, parts[4].trim(), parts[5].trim());
                } else if (type.equalsIgnoreCase("Premium")) {
                    member = new PremiumMemberTier(id, fee, parts[4].trim());
                } else if (type.equalsIgnoreCase("Group")) {
                    member = new GroupClassMemberTier(id, fee, parts[4].trim());
                } else {
                    member = new GymMemberTier(id, fee);
                }

                for (int s = 0; s < sessions; s++) {
                    member.attendSession();
                }
                list[i] = member;
            }

            for (GymMemberTier m : list) {
                System.out.println(m.displayInfo());
                System.out.println(classifyGeneration(m));
            }

            System.out.println(getTotalSessionsAttended(list));

            scanner.close();
        }
    }
}
