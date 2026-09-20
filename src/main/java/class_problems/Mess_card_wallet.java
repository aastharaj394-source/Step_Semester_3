package class_problems;
import.java.util.Scanner;
public class Mess_card_wallet {
    public class MessWallet {
        private double balance;

        public MessWallet(double openingBalance) {
            if (openingBalance < 0) {
                System.out.println("Warning: Opening balance cannot be negative. Setting balance to 0.0");
                this.balance = 0.0;
            } else {
                this.balance = openingBalance;
            }
        }

        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: Amount must be greater than 0");
                return;
            }
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }

        public void deduct(double amount) {
            if (amount <= 0) {
                System.out.println("Deduct rejected: Amount must be greater than 0");
                return;
            }
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else {
                balance -= amount;
                System.out.println("Balance after deduction: " + balance);
            }
        }

        public double getBalance() {
            return balance;
        }

        public static void main(String[] args) {
            MessWallet wallet = new MessWallet(500);
            wallet.topUp(200);
            wallet.deduct(1000);
            System.out.println("Final balance: " + wallet.getBalance());
        }
    }
}
