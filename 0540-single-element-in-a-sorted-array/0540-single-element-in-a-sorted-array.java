class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Ensure mid is even to check pairs (mid, mid + 1)
            if (mid % 2 == 1) {
                mid--;
            }
            
            // If pair matches, single element is on the right
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                // Otherwise, single element is on the left (including mid)
                high = mid;
            }
        }
        
        return nums[low];
    }
}