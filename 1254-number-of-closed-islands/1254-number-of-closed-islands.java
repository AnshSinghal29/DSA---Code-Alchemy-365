class Solution {
    int m,n;

    public boolean dfs(int[][] grid, int i,  int j){
        if(i<0 || i>=m || j < 0 || j>=n)return false;

        if(grid[i][j] == 1) return true;
        grid[i][j] = 1;

        boolean left = dfs(grid,i+1,j);
        boolean right = dfs(grid,i-1,j);
        boolean up = dfs(grid,i ,j+1);
        boolean down = dfs(grid,i,j-1);

        return left&&right&&up&&down;
    }
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;
        for(int i = 0; i < m;i ++){
            for(int j = 0; j <  n; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid,i,j))count++;
                }
            }
        }
        return count++;
    }
}