package class_problem;
import java.util.Scanner;
public class account_late_fee_calculation {
    class Account {
        String regNo;
        double totalFee;
        static final double LATE_FEE_RATE_PER_DAY = 0.01; // 1% per day

        public Account(String regNo, double totalFee) {
            this.regNo = regNo;
            this.totalFee = totalFee;
        }

        // Locked against being overridden
        public final double calculateLateFee(int daysLate) {
            return totalFee * LATE_FEE_RATE_PER_DAY * daysLate;
        }

        // Locked against being overridden
        public final void printSummary(int daysLate) {
            if (daysLate <= 0) {
                System.out.println(regNo + " - On time, no late fee");
            } else {
                double fee = calculateLateFee(daysLate);
                System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + fee);
            }
        }
    }

    public class AccountLateFeeCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of student accounts: ");
            int n = Integer.parseInt(scanner.nextLine().trim());

            Account[] accounts = new Account[n];
            int[] daysLateArr = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter Account " + (i + 1) + " (RegNo, TotalFee, DaysLate): ");
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String regNo = parts[0].trim();
                double totalFee = Double.parseDouble(parts[1].trim());
                int daysLate = Integer.parseInt(parts[2].trim());

                accounts[i] = new Account(regNo, totalFee);
                daysLateArr[i] = daysLate;
            }

            System.out.println("\n--- Batch Fee Processing ---");
            for (int i = 0; i < n; i++) {
                accounts[i].printSummary(daysLateArr[i]);
            }

            scanner.close();
        }
    }
}
