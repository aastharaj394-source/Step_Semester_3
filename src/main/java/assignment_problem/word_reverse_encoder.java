package assignment_problem;
import java.util.Scanner;
public class word_reverse_encoder {
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            result.append(wordBuilder.reverse());

            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String input = scanner.nextLine();
        String reversedSentence = reverseEachWord(input);
        System.out.println("Reversed sentence: " + reversedSentence);
        scanner.close();
    }
}
