package assignmnet_problem;
import java.util.Scanner;
public class Library_Member_JavaBean {
    public class LibraryMember {
        private String membershipId;
        private String name;
        private boolean premiumMember;
        private String securityAnswerHash;

        public LibraryMember() {
        }

        public String getMembershipId() {
            return membershipId;
        }

        public void setMembershipId(String id) {
            if (this.membershipId == null) {
                this.membershipId = id;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isPremiumMember() {
            return premiumMember;
        }

        public void setPremiumMember(boolean premium) {
            this.premiumMember = premium;
        }

        public void setSecurityAnswer(String answer) {
            if (answer != null) {
                this.securityAnswerHash = Integer.toHexString(answer.hashCode());
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            LibraryMember member = new LibraryMember();

            String id1 = scanner.nextLine().trim();
            member.setMembershipId(id1);

            String id2 = scanner.nextLine().trim();
            member.setMembershipId(id2);

            String name = scanner.nextLine().trim();
            member.setName(name);

            boolean isPrem = Boolean.parseBoolean(scanner.nextLine().trim());
            member.setPremiumMember(isPrem);

            String answer = scanner.nextLine().trim();
            member.setSecurityAnswer(answer);

            System.out.println(member.getMembershipId());
            System.out.println(member.getName());
            System.out.println(member.isPremiumMember());

            scanner.close();
        }
    }
}
