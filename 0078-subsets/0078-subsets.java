import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Har partial state ek valid subset hoti hai
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);                     // Choose
            backtrack(i + 1, nums, current, result);  // Explore
            current.remove(current.size() - 1);       // Unchoose (Backtrack)
        }
    }
}