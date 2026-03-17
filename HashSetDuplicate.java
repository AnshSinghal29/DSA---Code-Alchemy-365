
/**
 * [217] Contains Duplicate
 * -----------------------------------------------------------------------------
 * INTUITION:
 * To determine if any value appears at least twice, we need a way to "remember" 
 * the numbers we have already seen. A HashSet is the perfect tool for this 
 * because it allows us to check for existence and add new elements in 
 * constant time on average.
 *
 * APPROACH:
 * 1. Initialize an empty HashSet to store integers.
 * 2. Iterate through the input array `nums`.
 * 3. For each number:
 * - Check if it already exists in the set. If yes, we found a duplicate; return true.
 * - If no, add the number to the set and continue.
 * 4. If the loop finishes without finding any duplicates, return false.
 *
 * COMPLEXITY:
 * - Time Complexity: O(n), where n is the number of elements in the array. 
 * We traverse the array once, and HashSet operations (add/contains) are O(1).
 * - Space Complexity: O(n), as in the worst case (no duplicates), we store 
 * all n elements in the HashSet.
 * -----------------------------------------------------------------------------
 */

import java.util.HashSet;

class HashSetDuplicate {
     public boolean containsDuplicate(int[] nums) {
          // HashSet to keep track of unique elements encountered so far
          HashSet<Integer> set = new HashSet<>();

          for (int num : nums) {
               // If the element is already in the set, it's a duplicate
               if (set.contains(num)) {
                    return true;
               }
               // Add the current element to the set
               set.add(num);
          }

          // No duplicates found after checking all elements
          return false;
     }

     public static void main(String[] args) {
          System.out.println("Code compiled and executed successfully!");

     }
}
