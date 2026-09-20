package session_one_topics.assignment_problems;
import java.util.Scanner;
public class Typing_speed_accuracy_checker {
    public static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matchCount = 0;
        int firstMismatchIndex = -1;

        // Compare characters at each position
        for (int i = 0; i < totalChars; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchCount++;
            } else {
                // Record index of the first mismatch
                if (firstMismatchIndex == -1) {
                    firstMismatchIndex = i;
                }
            }
        }
        double accuracy = ((double) matchCount / totalChars) * 100.0;
        System.out.println("\n--- Typing Test Analysis ---");
        System.out.println("Total Characters : " + totalChars);
        System.out.println("Matched Correctly: " + matchCount);
        System.out.printf("Accuracy Rate    : %.2f%%\n", accuracy);
        if (firstMismatchIndex != -1) {
            System.out.println("First mismatch at position: " + (firstMismatchIndex + 1)
                    + " (Expected '" + original.charAt(firstMismatchIndex)
                    + "', but typed '" + typed.charAt(firstMismatchIndex) + "')");
        } else {
            System.out.println("Perfect typing! No mismatches detected.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the original reference passage: ");
        String original = scanner.nextLine();
        System.out.print("Enter your typed attempt: ");
        String typed = scanner.nextLine();
        if (original.length() != typed.length()) {
            System.out.println("\nError: The typed attempt must match the exact length of the original passage.");
            System.out.println("Original length: " + original.length() + ", Typed length: " + typed.length());
        } else {
            checkTypingAccuracy(original, typed);
        }
        scanner.close();
    }
}
