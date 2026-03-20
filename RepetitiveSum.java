
/**
// 
 * [Problem] Sum of Repetitiv
 * INTUITION:
 * We need to find the sum of all elements that appear more than once in the array.
 * By using a HashMap to store frequencies, we can easily identify which numbers 
 * are "repetitive" (frequency > 1) and add them to our total sum.
 *
 * APPROACH (Frequency Map + Filter):
 * 1. Create a HashMap to store the count of each element.
 * 2. Traverse the input array `nums` and populate the map using `getOrDefault`.
 * 3. Initialize a variable `sum = 0`.
 * 4. Iterate through the EntrySet of the map:
 * - If an element's value (count) is > 1, add that key (the number) to the sum.
 * 5. Return the final sum.
 *
 * COMPLEXITY:
 * - Time Complexity: O(n), where n is the number of elements. We traverse 
 * the array once (O(n)) and the unique elements in the map once (max O(n)).
 * - Space Complexity: O(u), where u is the number of unique elements 
 * stored in the map.
 * -----------------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

class RepetitiveSum {
    public int sumOfRepetitiveElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        // Step 1: Count occurrences of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sum up keys that have a frequency > 1
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                sum += entry.getKey();
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        RepetitiveSum calculator = new RepetitiveSum();

        // Example: 1 and 2 are repetitive. 1+2 = 3.
        int[] nums = { 1, 1, 2, 2, 3, 4, 5 };

        int result = calculator.sumOfRepetitiveElements(nums);
        System.out.println("Sum of repetitive elements: " + result);
    }
}
