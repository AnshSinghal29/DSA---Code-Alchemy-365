import java.util.Arrays;

class Solution {
    public String[] createGrid(int m, int n) {
        char[][] g = new char[m][n];
        
        // Step 1: Fill the entire grid with obstacles '#'
        for (int i = 0; i < m; i++) {
            Arrays.fill(g[i], '#');
        }
        
        // Step 2: Set all elements in the first row to '.'
        Arrays.fill(g[0], '.');
        
        // Step 3: Set all elements in the last column to '.'
        for (int i = 0; i < m; i++) {
            g[i][n - 1] = '.';
        }
        
        // Step 4: Convert char arrays to String array
        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            ans[i] = new String(g[i]);
        }
        
        return ans;
    }
}