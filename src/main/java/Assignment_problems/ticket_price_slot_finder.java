package Assignment_problems;
import java.util.Scanner;
public class ticket_price_slot_finder {
    public static int findSlot(int[] prices, int newPrice) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int low = 0;
        int high = prices.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (prices[mid] == newPrice) {
                return mid; // Exact match found
            } else if (prices[mid] < newPrice) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }

        // When the loop terminates (low > high), 'low' is positioned
        // at the exact insertion index where newPrice belongs.
        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};

        // Sample 1: Target exists
        System.out.println("Slot for 150: " + findSlot(prices, 150)); // Expected: 1

        // Sample 2: Target fits in the middle
        System.out.println("Slot for 210: " + findSlot(prices, 210)); // Expected: 3

        // Sample 3: Target belongs at the end
        System.out.println("Slot for 300: " + findSlot(prices, 300)); // Expected: 4

        // Edge case: Target smaller than all elements
        System.out.println("Slot for 100: " + findSlot(prices, 100)); // Expected: 0
    }

}
