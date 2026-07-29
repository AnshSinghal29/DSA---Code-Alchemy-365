class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // Tracks where to place the next even number
        int insertIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Check if the current number is even
            if (nums[i] % 2 == 0) {
                // Swap the even number to the front of the array
                int temp = nums[insertIndex];
                nums[insertIndex] = nums[i];
                nums[i] = temp;
                
                // Move the insertion pointer forward
                insertIndex++;
            }
        }
        
        return nums;
    }
}