import java.util.Arrays;

class Solution {
    int ans;
    int[][][] memo;
    
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ans = Integer.MAX_VALUE;
        
        // memo[r][c][xor_val] -> initialized with -1 (since XOR can be 0)
        memo = new int[m][n][1024];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        solve(0, 0, grid, grid[0][0]);
        return ans;
    }
    
    private void solve(int r, int c, int[][] grid, int val) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Base case: Reached bottom-right corner
        if (r == m - 1 && c == n - 1) {
            ans = Math.min(ans, val);
            return;
        }
        
        // If this state (r, c, val) has already been visited with a smaller or equal cost, return
        if (memo[r][c][val] != -1) {
            return;
        }
        memo[r][c][val] = 1;
        
        // Move Right
        if (c + 1 < n) {
            solve(r, c + 1, grid, val ^ grid[r][c + 1]);
        }
        
        // Move Down
        if (r + 1 < m) {
            solve(r + 1, c, grid, val ^ grid[r + 1][c]);
        }
    }
}