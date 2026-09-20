import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort the array to group duplicates together
        Arrays.sort(nums);
        
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Har valid state ek subset hai
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Step 2: Skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);                     // Choose
            backtrack(i + 1, nums, current, result);  // Explore
            current.remove(current.size() - 1);       // Unchoose (Backtrack)
        }
    }
}
