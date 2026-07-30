class Solution {
    public int[] sortedSquares(int[] nums) {
        int result[] = new int[nums.length];

        int left  = 0;
        int right = nums.length-1;
        for(int i = nums.length-1; i>=0; i--){
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            // Compare the squares and place the larger one at the current end
            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++; // Move the left pointer inward
            } else {
                result[i] = rightSquare;
                right--; // Move the right pointer inward
            }
        }
        return result;

    }
}