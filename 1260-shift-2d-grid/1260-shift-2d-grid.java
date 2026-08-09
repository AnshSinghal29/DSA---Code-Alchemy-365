class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                ans.get(i).add(0);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int newIndex = (i * n + j + k) % (m * n);

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return ans;
    }
}
