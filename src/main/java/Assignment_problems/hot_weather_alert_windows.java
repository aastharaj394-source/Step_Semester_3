package Assignment_problems;
import java.util.Scanner;
public class hot_weather_alert_windows {
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || readings.length < k || k <= 0) {
            return 0;
        }

        int alertCount = 0;
        int n = readings.length;

        // Using total required sum avoids floating-point precision issues:
        // average >= threshold  <=>  sum / k >= threshold  <=>  sum >= k * threshold
        long requiredSum = (long) k * threshold;

        // Step 1: Compute sum of the initial window of size k
        long currentWindowSum = 0;
        for (int i = 0; i < k; i++) {
            currentWindowSum += readings[i];
        }

        if (currentWindowSum >= requiredSum) {
            alertCount++;
        }

        // Step 2: Slide the window from index k to n - 1
        for (int i = k; i < n; i++) {
            // Add incoming reading and subtract outgoing reading
            currentWindowSum += readings[i] - readings[i - k];

            if (currentWindowSum >= requiredSum) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        int result = countAlerts(readings, k, threshold);
        System.out.println("Alert Count: " + result);
        // Expected Output: 3
    }
}
