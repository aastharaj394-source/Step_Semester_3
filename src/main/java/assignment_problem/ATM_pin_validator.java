package assignment_problem;
import java.util.Scanner;
public class ATM_pin_validator {
    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ATM PIN: ");
        String pin = scanner.nextLine().trim();
        checkPinLength(pin);
        scanner.close();
    }

}
