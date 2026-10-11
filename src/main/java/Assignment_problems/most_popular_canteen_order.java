package Assignment_problems;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class most_popular_canteen_order {
    public static class PopularItemResult {
        String item;
        int count;

        public PopularItemResult(String item, int count) {
            this.item = item;
            this.count = count;
        }

        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    /**
     * Finds the most frequently ordered item.
     * Ties are broken by choosing the item that appeared first in the original list.
     *
     * @param orders List/array of order names
     * @return PopularItemResult containing (item, count)
     */
    public static PopularItemResult mostPopular(String[] orders) {
        if (orders == null || orders.length == 0) {
            return new PopularItemResult("", 0);
        }

        // Pass 1: Count frequency of each item using a HashMap
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String order : orders) {
            frequencyMap.put(order, frequencyMap.getOrDefault(order, 0) + 1);
        }

        // Pass 2: Iterate through the original orders array to preserve first-appearance order
        String mostPopularItem = null;
        int maxCount = 0;

        for (String order : orders) {
            int count = frequencyMap.get(order);
            // Strict inequality (>) ensures that the first item achieving maxCount is kept
            if (count > maxCount) {
                maxCount = count;
                mostPopularItem = order;
            }
        }

        return new PopularItemResult(mostPopularItem, maxCount);
    }

    public static void main(String[] args) {
        // Sample 1
        String[] orders1 = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        PopularItemResult result1 = mostPopular(orders1);
        System.out.println("Sample 1: " + result1);
        // Expected Output: ("dosa", 3)

        // Sample 2 (Tie breaker: both "tea" and "coffee" appear 2 times, "tea" appeared first)
        String[] orders2 = {"tea", "coffee", "coffee", "tea"};
        PopularItemResult result2 = mostPopular(orders2);
        System.out.println("Sample 2: " + result2);
        // Expected Output: ("tea", 2)
    }
}
