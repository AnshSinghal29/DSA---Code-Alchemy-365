class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Agar pehla character match ho, to DFS start karo
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Base case: agar saare characters match ho gaye
        if (index == word.length()) {
            return true;
        }

        // Boundary check, character mismatch check, aur visited check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited temporarily
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 directions: Down, Up, Right, Left
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        // Backtrack: restore the original character
        board[i][j] = temp;

        return found;
    }
}