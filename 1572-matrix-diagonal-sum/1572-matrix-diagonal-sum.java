class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        
        // Single loop to grab both diagonals simultaneously
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];             // Add primary diagonal element
            sum += mat[i][n - 1 - i];     // Add secondary diagonal element
        }
        
        // If the matrix has an odd length, we double-counted the center element!
        // We must subtract it once.
        if (n % 2 != 0) {
            sum -= mat[n / 2][n / 2];
        }
        
        return sum;
    }
}