package assignment_problem;
import java.util.*;
public class word_frequency_report {
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No words to analyze.");
            return;
        }

        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "");

        String[] words = cleaned.trim().split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter feedback paragraph:");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}
