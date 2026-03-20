
/**
 * [Pattern] Frequency Counting in an Array
 * -----------------------------------------------------------------------------
 * INTUITION:
 * To count how many times each element appears in an array, we need a 
 * data structure that can associate a "Value" with its "Count". 
 * A HashMap <Integer, Integer> is the optimal choice because it allows 
 * us to check and update counts in constant time on average.
 *
 * APPROACH (Frequency Mapping):
 * 1. Initialize an empty HashMap where:
 * - Key = The number from the array.
 * - Value = The frequency (count) of that number.
 * 2. Iterate through the array `nums`.
 * 3. For each number:
 * - Check if it already exists in the map.
 * - If yes, increment its current count by 1.
 * - If no, add it to the map with an initial count of 1.
 * - *Pro Tip:* Use `map.getOrDefault(num, 0) + 1` for cleaner code.
 * 4. After the loop, the map contains the exact frequency of every element.
 *
 * COMPLEXITY:
 * - Time Complexity: O(n), where n is the length of the array. We traverse 
 * the array once, and HashMap operations are O(1).
 * - Space Complexity: O(u), where u is the number of unique elements 
 * stored in the map (worst case O(n)).
 * -----------------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

class FreqCountHashMap {
    public Map<Integer, Integer> countOccurrences(int[] nums) {
        // Map to store: Key = Number, Value = Frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            // getOrDefault handles the case where the key doesn't exist yet
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map;
    }

    // Main function for local testing
    public static void main(String[] args) {
        FreqCountHashMap counter = new FreqCountHashMap();
        int[] nums = { 1, 2, 2, 3, 1, 4, 2, 1, 5 };

        Map<Integer, Integer> result = counter.countOccurrences(nums);

        // Printing the results nicely
        System.out.println("Element Frequencies:");
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println("Number " + entry.getKey() + " appears " + entry.getValue() + " times.");
        }
    }
}