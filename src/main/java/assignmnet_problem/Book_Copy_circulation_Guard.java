package assignmnet_problem;
import java.util.Scanner;
public class Book_Copy_circulation_Guard {
    public class BookInventory {
        private int copiesTotal;
        private int copiesAvailable;

        public BookInventory(int copiesTotal) {
            if (copiesTotal <= 0) {
                this.copiesTotal = 0;
                this.copiesAvailable = 0;
            } else {
                this.copiesTotal = copiesTotal;
                this.copiesAvailable = copiesTotal;
            }
        }

        public void checkOut() {
            if (copiesAvailable > 0) {
                copiesAvailable--;
            }
        }

        public void checkIn() {
            if (copiesAvailable < copiesTotal) {
                copiesAvailable++;
            }
        }

        public int getCopiesAvailable() {
            return copiesAvailable;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int total = Integer.parseInt(scanner.nextLine().trim());

            BookInventory inventory = new BookInventory(total);
            int operations = Integer.parseInt(scanner.nextLine().trim());

            for (int i = 0; i < operations; i++) {
                String op = scanner.nextLine().trim();
                if (op.equalsIgnoreCase("checkout")) {
                    inventory.checkOut();
                } else if (op.equalsIgnoreCase("checkin")) {
                    inventory.checkIn();
                }
            }

            System.out.println(inventory.getCopiesAvailable());
            scanner.close();
        }
    }
}
