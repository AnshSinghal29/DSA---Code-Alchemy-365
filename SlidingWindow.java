
/**
 * [219] Contains Duplicate II
 * -----------------------------------------------------------------------------
 * INTUITION:
 * We need to check if a duplicate exists within a specific distance 'k'. 
 * By using a HashMap, we can store each number as a 'key' and its latest index 
 * as the 'value'. When we encounter a number already in the map, we simply 
 * calculate the gap between the current index and the stored index.
 *
 * APPROACH (HashMap for Index Tracking):
 * 1. Create a HashMap <Integer, Integer> to store {Value -> Last_Seen_Index}.
 * 2. Iterate through the array. For each element:
 * - If it's already in the map, retrieve the previous index.
 * - Calculate if (current_index - previous_index <= k).
 * - If yes, return true immediately.
 * - Update the map with the current index (this ensures we always check 
 * against the closest previous occurrence).
 * 3. If the loop completes, return false.
 *
 * COMPLEXITY:
 * - Time Complexity: O(n), where n is the length of the array. Each lookup 
 * and insertion in the HashMap is O(1) on average.
 * - Space Complexity: O(n) in the worst case where all elements are unique.
 * -----------------------------------------------------------------------------
 */

import java.util.HashMap;

class SlidingWindow {
     public boolean containsNearbyDuplicate(int[] nums, int k) {
          // Map to store: Key = Number, Value = Its most recent index
          HashMap<Integer, Integer> map = new HashMap<>();

          for (int i = 0; i < nums.length; i++) {
               int num = nums[i];

               // If the number was seen before, check the distance
               if (map.containsKey(num)) {
                    int prevIndex = map.get(num);
                    if (i - prevIndex <= k) {
                         return true;
                    }
               }

               // Always update the map with the latest index of the number
               map.put(num, i);
          }

          return false;
     }

     // Main function for local testing
     public static void main(String[] args) {
          SlidingWindow sol = new SlidingWindow();

          // Test Case 1
          int[] nums1 = { 1, 2, 3, 1 };
          int k1 = 3;
          System.out.println("Test 1 (Expected: true): " + sol.containsNearbyDuplicate(nums1, k1));

          // Test Case 2
          int[] nums2 = { 1, 0, 1, 1 };
          int k2 = 1;
          System.out.println("Test 2 (Expected: true): " + sol.containsNearbyDuplicate(nums2, k2));

          // Test Case 3
          int[] nums3 = { 1, 2, 3, 1, 2, 3 };
          int k3 = 2;
          System.out.println("Test 3 (Expected: false): " + sol.containsNearbyDuplicate(nums3, k3));
     }
}
