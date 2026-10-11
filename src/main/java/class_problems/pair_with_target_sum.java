package class_problems;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
public class pair_with_target_sum {
    public static boolean hasPairWithSumHashSet(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    /**
     * Approach 2: Sorting + Two Pointers (Optimal for In-Place / Low Auxiliary Space)
     * Sorts a copy of the array and uses two pointers moving inward.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n) for copy, or O(1) auxiliary if sorting in-place
     */
    public static boolean hasPairWithSumTwoPointers(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        // Clone array to avoid mutating original input
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = 0;
        int right = sorted.length - 1;

        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    /**
     * Approach 3: Brute Force (Baseline)
     * Checks all possible distinct pairs (i != j).
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Sample 1 (HashSet): " + hasPairWithSumHashSet(nums1, target1)); // true
        System.out.println("Sample 1 (Two Pointers): " + hasPairWithSumTwoPointers(nums1, target1)); // true

        // Sample 2
        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        System.out.println("Sample 2 (HashSet): " + hasPairWithSumHashSet(nums2, target2)); // false
        System.out.println("Sample 2 (Two Pointers): " + hasPairWithSumTwoPointers(nums2, target2)); // false
    }

}
