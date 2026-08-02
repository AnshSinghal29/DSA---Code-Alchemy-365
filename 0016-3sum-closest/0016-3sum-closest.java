class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 1. Must sort the array for the two-pointer technique to work!
        Arrays.sort(nums);
        
        // Initialize closestSum with the first possible triplet sum
        int closestSum = nums[0] + nums[1] + nums[2]; 
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Optional optimization: skip duplicate 'A's
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // If this new sum is closer to the target than our recorded closestSum, update it!
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                
                // Move pointers based on how we compare to the target
                if (sum < target) {
                    left++; // We need a larger sum to get closer
                } else if (sum > target) {
                    right--; // We need a smaller sum to get closer
                } else {
                    // If sum == target, the difference is 0. You can't get closer than 0!
                    return sum; 
                }
            }
        }
        
        return closestSum;
    }
}