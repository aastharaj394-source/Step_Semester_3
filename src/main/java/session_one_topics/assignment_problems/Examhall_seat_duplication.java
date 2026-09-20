package session_one_topics.assignment_problems;
import java.util.Scanner;
public class Examhall_seat_duplication {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        System.out.println("\nSeating Verification Scan");
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    // Check to avoid printing the same duplicated seat multiple times
                    boolean alreadyPrinted = false;
                    for (int k = 0; k < i; k++) {
                        if (seatNumbers[k] == seatNumbers[i]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }
                    if (!alreadyPrinted) {
                        System.out.println("Duplicate detected: Seat number " + seatNumbers[i] + " is assigned more than once!");
                        duplicateFound = true;
                    }
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("Verification successful: No duplicate seats found. All allocations are unique.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of allocated seats: ");
        int n = scanner.nextInt();
        int[] seatNumbers = new int[n];
        System.out.println("Enter the " + n + " seat numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Seat allocation [" + (i + 1) + "]: ");
            seatNumbers[i] = scanner.nextInt();
        }
        checkDuplicateSeats(seatNumbers);
        scanner.close();
    }
}
