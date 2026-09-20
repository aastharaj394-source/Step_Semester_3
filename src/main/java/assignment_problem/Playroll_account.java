package assignment_problem;
import java.util.Scanner;
public class Playroll_account {
    class PayrollAccount {
        private double basicSalary;
        private double bonus;

        public PayrollAccount(double basicSalary) {
            if (basicSalary < 0) {
                System.out.println("Warning: Basic salary cannot be negative. Setting to 0.0");
                this.basicSalary = 0.0;
            } else {
                this.basicSalary = basicSalary;
            }
            this.bonus = 0.0;
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus rejected: Amount must be greater than 0");
                return;
            }
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax deduction rejected: Percent must be between 0 and 100");
                return;
            }
            double taxAmount = (basicSalary * percent) / 100.0;
            basicSalary -= taxAmount;
            System.out.println("Tax deducted: " + (int) percent + "%");
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public class PayrollAccountManager {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter basic salary: ");
            double salary = scanner.nextDouble();
            PayrollAccount account = new PayrollAccount(salary);

            System.out.print("Enter bonus amount to credit: ");
            double bonus = scanner.nextDouble();
            account.creditBonus(bonus);

            System.out.print("Enter tax percentage to deduct: ");
            double tax = scanner.nextDouble();
            account.deductTax(tax);

            System.out.println("Net salary: Rs " + account.getNetSalary());

            scanner.close();
        }
    }
}
