package class_problem;
import java.util.Scanner;
public class account_batch_payment {
    class FeeAccount {
        String studentName;

        public FeeAccount(String studentName) {
            this.studentName = studentName;
        }
    }

    class HostelFeeAccount extends FeeAccount {
        public HostelFeeAccount(String studentName) {
            super(studentName);
        }
    }

    public class BatchAccountPaymentProcessor {

        public static void processPayment(FeeAccount account, double amount) {
            if (account instanceof HostelFeeAccount) {
                System.out.println("Paid in two installments (hostel account)");
            } else if (account instanceof FeeAccount) {
                System.out.println("Paid in one go (day-scholar account)");
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of accounts to process: ");
            int total = Integer.parseInt(scanner.nextLine().trim());

            FeeAccount[] batch = new FeeAccount[total];

            System.out.println("Enter account type for each student (H for Hostel, D for Day-scholar):");
            for (int i = 0; i < total; i++) {
                System.out.print("Student " + (i + 1) + " (Type, Name): ");
                String line = scanner.nextLine().trim();
                String[] parts = line.split(",");
                String type = parts[0].trim().toUpperCase();
                String name = parts[1].trim();

                if (type.equals("H")) {
                    batch[i] = new HostelFeeAccount(name);
                } else {
                    batch[i] = new FeeAccount(name);
                }
            }

            System.out.print("\nEnter payment amount for each account: ");
            double paymentAmount = Double.parseDouble(scanner.nextLine().trim());

            int hostelCount = 0;
            int dayScholarCount = 0;

            System.out.println("\n--- Processing Output ---");
            for (FeeAccount acc : batch) {
                processPayment(acc, paymentAmount);

                if (acc instanceof HostelFeeAccount) {
                    hostelCount++;
                } else {
                    dayScholarCount++;
                }
            }

            System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);

            scanner.close();
        }
    }
}
