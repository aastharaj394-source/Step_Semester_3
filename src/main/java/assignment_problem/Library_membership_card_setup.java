package assignment_problem;
import java.util.Scanner;
public class Library_membership_card_setup {
    class MembershipCard {
        static String libraryName;
        static String validUntil;
        String studentName;

        static {
            libraryName = "SRM Central Library";
            validUntil = "May 2027";
            System.out.println("Library info loaded");
        }

        public MembershipCard(String studentName) {
            this.studentName = studentName;
        }
    }

    public class LibraryCardIssuer {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of membership cards to issue: ");
            int n = Integer.parseInt(scanner.nextLine().trim());

            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter student " + (i + 1) + " name: ");
                names[i] = scanner.nextLine().trim();
            }

            System.out.println();
            for (int i = 0; i < n; i++) {
                MembershipCard card = new MembershipCard(names[i]);
                System.out.println("Membership card issued: " + card.studentName);
            }

            scanner.close();
        }
    }
}
