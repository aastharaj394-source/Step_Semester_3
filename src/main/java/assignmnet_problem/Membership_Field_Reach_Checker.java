package assignmnet_problem;
import java.util.Scanner;
public class Membership_Field_Reach_Checker {
    class LibraryMember {
        private String membershipPin;
        String branchCode;
        protected double finesOwed;
        public String displayName;

        public LibraryMember(String membershipPin, String branchCode, double finesOwed, String displayName) {
            this.membershipPin = membershipPin;
            this.branchCode = branchCode;
            this.finesOwed = finesOwed;
            this.displayName = displayName;
        }
    }

    public class AccessChecker {

        public static String classifyAccess(String fieldModifier, String accessorContext) {
            switch (fieldModifier.toLowerCase()) {
                case "public":
                    return "ALLOWED";
                case "protected":
                    if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) {
                        return "ALLOWED";
                    }
                    return "DENIED";
                case "default":
                    if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) {
                        return "ALLOWED";
                    }
                    return "DENIED";
                case "private":
                    if (accessorContext.equals("SAME_CLASS")) {
                        return "ALLOWED";
                    }
                    return "DENIED";
                default:
                    return "DENIED";
            }
        }

        public static String summarizeByModifier(String[][] attempts) {
            int privAllowed = 0, privDenied = 0;
            int defAllowed = 0, defDenied = 0;
            int protAllowed = 0, protDenied = 0;
            int pubAllowed = 0, pubDenied = 0;

            for (String[] attempt : attempts) {
                String modifier = attempt[0].toLowerCase();
                String context = attempt[1];
                String result = classifyAccess(modifier, context);

                switch (modifier) {
                    case "private":
                        if (result.equals("ALLOWED")) privAllowed++;
                        else privDenied++;
                        break;
                    case "default":
                        if (result.equals("ALLOWED")) defAllowed++;
                        else defDenied++;
                        break;
                    case "protected":
                        if (result.equals("ALLOWED")) protAllowed++;
                        else protDenied++;
                        break;
                    case "public":
                        if (result.equals("ALLOWED")) pubAllowed++;
                        else pubDenied++;
                        break;
                }
            }

            return "private: " + privAllowed + " allowed / " + privDenied + " denied | " +
                    "default: " + defAllowed + " allowed / " + defDenied + " denied | " +
                    "protected: " + protAllowed + " allowed / " + protDenied + " denied | " +
                    "public: " + pubAllowed + " allowed / " + pubDenied + " denied";
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine().trim());

            String[][] attempts = new String[n][2];
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                attempts[i][0] = parts[0].trim();
                attempts[i][1] = parts[1].trim();
            }

            System.out.println(summarizeByModifier(attempts));
            scanner.close();
        }
    }
}
