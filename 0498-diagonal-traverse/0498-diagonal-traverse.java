class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        
        int row = 0;
        int col = 0;
        
        for (int i = 0; i < result.length; i++) {
            result[i] = mat[row][col];
            
            // IF EVEN: Moving Up-Right
            if ((row + col) % 2 == 0) {
                if (col == n - 1) { 
                    row++; // Hit the right wall, move down
                } else if (row == 0) { 
                    col++; // Hit the top wall, move right
                } else {
                    row--; col++; // Normal up-right movement
                }
            } 
            // IF ODD: Moving Down-Left
            else {
                if (row == m - 1) { 
                    col++; // Hit the bottom wall, move right
                } else if (col == 0) { 
                    row++; // Hit the left wall, move down
                } else {
                    row++; col--; // Normal down-left movement
                }
            }
        }
        
        return result;
    }
}