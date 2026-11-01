import java.util.Arrays;

class Solution {
    public int minMoves(int[] nums) {
        // Find the minimum element in the array
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        
        // Accumulate the difference between each element and the minimum
        int moves = 0;
        for (int num : nums) {
            moves += (num - min);
        }
        
        return moves;
    }
}