package Assignment_problems;
import java.util.Scanner;
public class class_topper_finder {
    public static class TopperResult {
        int rowIndex;
        int total;

        public TopperResult(int rowIndex, int total) {
            this.rowIndex = rowIndex;
            this.total = total;
        }

        @Override
        public String toString() {
            return "(" + rowIndex + ", " + total + ")";
        }
    }

    /**
     * Finds the student with the highest total marks across all subjects.
     * In case of a tie, returns the one with the smallest row index.
     *
     * @param marks 2D array where marks[i][j] represents marks of student i in subject j
     * @return TopperResult holding the topper's rowIndex and their total marks
     */
    public static TopperResult findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) {
            return new TopperResult(-1, 0);
        }

        int bestRowIndex = 0;
        int maxTotal = -1;

        int m = marks.length; // Number of students

        for (int i = 0; i < m; i++) {
            int currentTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                currentTotal += marks[i][j];
            }

            // Using strict inequality (>) guarantees that if there is a tie,
            // the earlier (smaller) row index is retained.
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRowIndex = i;
            }
        }

        return new TopperResult(bestRowIndex, maxTotal);
    }

    public static void main(String[] args) {
        int[][] marks = {
                {78, 85, 90},
                {88, 92, 79},
                {65, 70, 95}
        };

        TopperResult result = findTopper(marks);
        System.out.println("Output: " + result);
        // Expected Output: (1, 259)
    }
}
