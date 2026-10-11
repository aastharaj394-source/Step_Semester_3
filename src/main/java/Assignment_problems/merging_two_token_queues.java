package Assignment_problems;
import java.util.Scanner;
import java.util.Arrays;
public class merging_two_token_queues {
    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        // Handle null safety
        if (counterA == null) counterA = new int[0];
        if (counterB == null) counterB = new int[0];

        int m = counterA.length;
        int n = counterB.length;
        int[] merged = new int[m + n];

        int i = 0; // Pointer for counterA
        int j = 0; // Pointer for counterB
        int k = 0; // Pointer for merged array

        // Compare elements and place the smaller one into the merged array
        while (i < m && j < n) {
            if (counterA[i] <= counterB[j]) {
                merged[k++] = counterA[i++];
            } else {
                merged[k++] = counterB[j++];
            }
        }

        // Copy any remaining elements from counterA
        while (i < m) {
            merged[k++] = counterA[i++];
        }

        // Copy any remaining elements from counterB
        while (j < n) {
            merged[k++] = counterB[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] counterA1 = {3, 8, 15, 20};
        int[] counterB1 = {5, 8, 12};
        int[] result1 = mergeTokens(counterA1, counterB1);
        System.out.println("Sample 1: " + Arrays.toString(result1));
        // Expected Output: [3, 5, 8, 8, 12, 15, 20]

        // Sample 2
        int[] counterA2 = {};
        int[] counterB2 = {4, 9};
        int[] result2 = mergeTokens(counterA2, counterB2);
        System.out.println("Sample 2: " + Arrays.toString(result2));
        // Expected Output: [4, 9]
    }
}