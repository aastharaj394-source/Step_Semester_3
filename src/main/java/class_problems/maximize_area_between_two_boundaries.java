package class_problems;
import java.util.Scanner;
public class maximize_area_between_two_boundaries {
    public static int maxContainerArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int currentArea = height * width;

            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter wall inward
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Brute-Force Solution: Evaluates every possible pair (i, j).
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int maxContainerAreaBruteForce(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = Math.min(heights[i], heights[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int resultOptimal = maxContainerArea(heights);
        int resultBruteForce = maxContainerAreaBruteForce(heights);

        System.out.println("Max Area (Two-Pointer): " + resultOptimal);     // 49
        System.out.println("Max Area (Brute-Force): " + resultBruteForce); // 49
    }
}
