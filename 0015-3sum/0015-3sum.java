class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        // 2. Loop to fix the first number 'A'
        for (int i = 0; i < nums.length - 2; i++) {
            // How do you prevent duplicate 'A's from being processed?
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // We found a match! Add it to the result list.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move both pointers inward
                    left++;
                    right--;
                    
                    // How do you skip duplicate elements for 'left' and 'right' here?
                   while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                    
                } else if (sum < 0) {
                    // Increment left pointer
                    left++;
                } else {
                    // Decrement right pointer
                    right--;
                }
            }
        }
        
        return result;
    }
}