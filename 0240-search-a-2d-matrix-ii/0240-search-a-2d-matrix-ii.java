class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Edge case for empty matrices
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = 0;
        int col = matrix[0].length - 1; // Start at the top-right corner
        
        // Keep going until we fall off the bottom or left edge
        while (row < matrix.length && col >= 0) {
            
            if (matrix[row][col] == target) {
                return true; 
            } 
            else if (matrix[row][col] > target) {
                // Current number is too big, eliminate this column
                col--; 
            } 
            else {
                // Current number is too small, eliminate this row
                row++; 
            }
        }
        
        return false;
    }
}