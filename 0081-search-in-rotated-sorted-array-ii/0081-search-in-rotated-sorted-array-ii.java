class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Duplicates handle karne ke liye ambiguity skip karo
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } 
            // Check if left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target left half mein hai
                } else {
                    left = mid + 1;  // Target right half mein hai
                }
            } 
            // Otherwise, right half must be sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Target right half mein hai
                } else {
                    right = mid - 1; // Target left half mein hai
                }
            }
        }

        return false;
    }
}