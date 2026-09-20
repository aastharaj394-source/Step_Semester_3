package class_problems;
import java.util.Scanner;
public class Bank_transaction_transfer {
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }
    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: Wrong length (expected 14 characters, got " + reference.length() + ").";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: Bank code must consist of 3 letters only.";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: Remaining 11 characters must all be numeric digits.";
            }
        }
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
                .append(day).append("/").append(month).append("/").append(year)
                .append(" | SEQ: ").append(seq);

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transaction reference code: ");
        String rawInput = scanner.nextLine();
        String normalized = normalizeReference(rawInput);
        String result = validateAndFormat(normalized);
        System.out.println(result);
        scanner.close();
    }
}
