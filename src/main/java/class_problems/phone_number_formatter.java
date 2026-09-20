package class_problems;
import java.util.Scanner;
public class phone_number_formatter {
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Error: Invalid phone number length. Must be exactly 10 digits.";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Error: Invalid format. Phone number must contain digits only.";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX-");
        sb.append(phone.substring(6));
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10-digit phone number: ");
        String phoneInput = scanner.nextLine().trim();

        String result = maskPhoneNumber(phoneInput);
        System.out.println("Masked Output: " + result);

        scanner.close();
    }
}
