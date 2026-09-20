package session_one_topics.assignment_problems;
import java.util.Scanner;
public class Traffic_signal_analyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Log is empty. No signal readings recorded.");
            return;
        }
        String log = signalLog.toUpperCase();
        char maxColor = log.charAt(0);
        int maxStreak = 1;
        char currentColor = log.charAt(0);
        int currentStreak = 1;
        for (int i = 1; i < log.length(); i++) {
            char ch = log.charAt(i);

            if (ch == currentColor) {
                currentStreak++;
            } else {
                currentColor = ch;
                currentStreak = 1;
            }
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                maxColor = currentColor;
            }
        }
        String colorName;
        switch (maxColor) {
            case 'R':
                colorName = "Red (R)";
                break;
            case 'G':
                colorName = "Green (G)";
                break;
            case 'Y':
                colorName = "Yellow (Y)";
                break;
            default:
                colorName = "Unknown ('" + maxColor + "')";
                break;
        }
        System.out.println("\n--- Traffic Signal Log Analysis ---");
        System.out.println("Full Sequence  : " + log);
        System.out.println("Longest Streak : " + maxStreak + " minutes");
        System.out.println("Stuck Color    : " + colorName);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the signal reading sequence (e.g., RRGGGYRR): ");
        String readings = scanner.nextLine().trim();
        findLongestStreak(readings);
        scanner.close();
    }
}
