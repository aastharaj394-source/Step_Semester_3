package Class_problem;
import java.util.Scanner;
public class Movie_ticket_field_visibility {
    class MovieTicket {
        private String seatNumber;
        String screenId;
        protected double ticketPrice;
        public String movieTitle;

        public MovieTicket(String seatNumber, String screenId, double ticketPrice, String movieTitle) {
            this.seatNumber = seatNumber;
            this.screenId = screenId;
            this.ticketPrice = ticketPrice;
            this.movieTitle = movieTitle;
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

        public static String summarizeBatch(String[][] attempts) {
            int allowed = 0;
            int denied = 0;

            for (String[] attempt : attempts) {
                String result = classifyAccess(attempt[0], attempt[1]);
                if (result.equals("ALLOWED")) {
                    allowed++;
                } else {
                    denied++;
                }
            }
            return "Allowed: " + allowed + " | Denied: " + denied;
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

            for (int i = 0; i < n; i++) {
                System.out.println(classifyAccess(attempts[i][0], attempts[i][1]));
            }

            System.out.println(summarizeBatch(attempts));
            scanner.close();
        }
    }
}
