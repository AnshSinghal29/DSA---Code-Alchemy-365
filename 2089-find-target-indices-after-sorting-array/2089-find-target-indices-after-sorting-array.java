import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessCount = 0;
        int equalCount = 0;

        // Step 1: Count elements smaller than target and equal to target
        for (int num : nums) {
            if (num < target) {
                lessCount++;
            } else if (num == target) {
                equalCount++;
            }
        }

        // Step 2: Generate the indices list
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < equalCount; i++) {
            result.add(lessCount + i);
        }

        return result;
    }
}