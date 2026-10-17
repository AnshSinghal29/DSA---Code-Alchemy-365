
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Custom wrapper class to store number, its index, and its digit sum
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on custom rules: digit sum ascending, then value ascending
        Arrays.sort(indices, (a, b) -> {
            int sumA = getDigitSum(nums[a]);
            int sumB = getDigitSum(nums[b]);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(nums[a], nums[b]);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Find cycles to count minimum swaps
        for (int i = 0; i < n; i++) {
            // Agar element already visited hai ya apni sahi jagah par hai
            if (visited[i] || indices[i] == i) {
                continue;
            }

            // Cycle length find karo
            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = indices[curr];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    // Helper function to calculate digit sum of a number
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}