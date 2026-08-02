class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort!
        Arrays.sort(nums);
        
        // 2. First loop (Fix A)
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicate 'A's
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            // 3. Second loop (Fix B)
            for (int j = i + 1; j < nums.length - 2; j++) {
                // Fixed: Check j > i + 1 so we don't skip the first valid 'B'
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                
                int left = j + 1;
                int right = nums.length - 1;
                
                // 4. Two Pointers
                while (left < right) {
                    // 5. Watch out for the overflow trap!
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        left++;
                        right--;
                        
                        // Skip duplicate C's and D's
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                        
                    // Fixed: Brackets are now properly aligned
                    } else if (sum < target) {
                        left++;
                    } else {
                        // Fixed: Decrement right pointer and added semicolon
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}