package assignment_problem;
import java.util.Scanner;
public class Canteen_Closing_Time_Payment_Dispatch {
    class Payment {
        public double pay(double amount) {
            System.out.println("Paid (cash): Rs " + amount);
            return amount;
        }
    }

    class CardPayment extends Payment {
        public double payWithProcessingFee(double amount) {
            double total = amount + (amount * 0.02);
            System.out.println("Charged (card, incl. fee): Rs " + total);
            return total;
        }
    }

    public class CanteenPaymentDispatch {

        public static double processTransaction(Payment payment, double amount) {
            if (payment instanceof CardPayment) {
                return ((CardPayment) payment).payWithProcessingFee(amount);
            } else {
                return payment.pay(amount);
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of transactions: ");
            int n = Integer.parseInt(scanner.nextLine().trim());

            Payment[] payments = new Payment[n];
            double[] amounts = new double[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Transaction " + (i + 1) + " payment type (Card/Cash): ");
                String type = scanner.nextLine().trim();

                System.out.print("Transaction " + (i + 1) + " amount: ");
                amounts[i] = Double.parseDouble(scanner.nextLine().trim());

                if (type.equalsIgnoreCase("Card")) {
                    payments[i] = new CardPayment();
                } else {
                    payments[i] = new Payment();
                }
            }

            System.out.println();
            double totalCollected = 0.0;
            for (int i = 0; i < n; i++) {
                totalCollected += processTransaction(payments[i], amounts[i]);
            }

            System.out.println("Total Collected: Rs " + totalCollected);

            scanner.close();
        }
    }
}
