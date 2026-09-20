package Class_problem;
import java.util.Scanner;
public class seat_booking {
    public class CineScreen {
        private int seatsTotal;
        private int seatsAvailable;

        public CineScreen(int seatsTotal) {
            if (seatsTotal <= 0) {
                System.out.println("construction rejected");
                this.seatsTotal = 0;
                this.seatsAvailable = 0;
            } else {
                this.seatsTotal = seatsTotal;
                this.seatsAvailable = seatsTotal;
            }
        }

        public void bookSeat() {
            if (seatsAvailable > 0) {
                seatsAvailable--;
            }
        }

        public void cancelBooking() {
            if (seatsAvailable < seatsTotal) {
                seatsAvailable++;
            }
        }

        public int getSeatsAvailable() {
            return seatsAvailable;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int totalSeats = Integer.parseInt(scanner.nextLine().trim());

            CineScreen screen = new CineScreen(totalSeats);
            if (totalSeats > 0) {
                int operations = Integer.parseInt(scanner.nextLine().trim());
                for (int i = 0; i < operations; i++) {
                    String op = scanner.nextLine().trim();
                    if (op.equalsIgnoreCase("book")) {
                        screen.bookSeat();
                    } else if (op.equalsIgnoreCase("cancel")) {
                        screen.cancelBooking();
                    }
                }
                System.out.println(screen.getSeatsAvailable());
            }

            scanner.close();
        }
    }
}
