package session_one_topics.assignment_problems;
import java.util.Scanner;
public class Movie_Review {
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("No words found in the review.");
            return;
        }
        String[] words = review.trim().split("\\s+");
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        for (int i = 0; i < words.length; i++) {
            String cleanWord = words[i].replaceAll("[^a-zA-Z]", "");
            int len = cleanWord.length();
            if (len >= 1 && len <= 4) {
                shortWords++;
            } else if (len >= 5 && len <= 8) {
                mediumWords++;
            } else if (len >= 9) {
                longWords++;
            }
        }
        int totalWords = shortWords + mediumWords + longWords;
        System.out.println("\n--- Movie Review Word Length Profile ---");
        System.out.println("Total Valid Words : " + totalWords);
        System.out.println("Short Words (1-4 letters): " + shortWords);
        System.out.println("Medium Words (5-8 letters): " + mediumWords);
        System.out.println("Long Words (9+ letters) : " + longWords);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter movie review: ");
        String review = scanner.nextLine();
        classifyWordLengths(review);
        scanner.close();
    }
}
