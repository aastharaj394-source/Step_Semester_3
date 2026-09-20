package assignment_problem;
import java.util.Scanner;
public class library_ISBN {
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }
    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: Wrong length (expected 13 characters, got " + code.length() + ").";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: Publisher code must consist of 3 letters only.";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: Remaining 10 characters must all be numeric digits.";
            }
        }
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ")
                .append(year).append(" | CATALOG: ")
                .append(catalog);

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter library ISBN code: ");
        String rawInput = scanner.nextLine();
        String normalized = normalizeCode(rawInput);
        String result = validateAndFormat(normalized);
        System.out.println(result);
        scanner.close();
    }
}
