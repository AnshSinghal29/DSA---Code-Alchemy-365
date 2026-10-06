class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        result[0] = findBound(nums, target, true);  // Find first position
        result[1] = findBound(nums, target, false); // Find last position
        
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int boundIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                boundIndex = mid; // Potential bound found
                if (isFirst) {
                    right = mid - 1; // Left side aur explore karo pehla index ke liye
                } else {
                    left = mid + 1;  // Right side aur explore karo aakhri index ke liye
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return boundIndex;
    }
}