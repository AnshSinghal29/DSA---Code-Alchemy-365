import java.util.*;

public class RatInaMaze {

     public static void findPaths(int[][] maze, int r, int c, String path, boolean[][] visited, ArrayList<String> ans) {
          int n = maze.length;

          // Base Case: Destination reached (N-1, N-1)
          if (r == n - 1 && c == n - 1) {
               ans.add(path);
               return;
          }

          // Mark current cell as visited so we don't return to it in the current path
          visited[r][c] = true;

          // Move Down
          if (isSafe(maze, r + 1, c, visited)) {
               findPaths(maze, r + 1, c, path + "D", visited, ans);
          }

          // Move Left
          if (isSafe(maze, r, c - 1, visited)) {
               findPaths(maze, r, c - 1, path + "L", visited, ans);
          }

          // Move Right
          if (isSafe(maze, r, c + 1, visited)) {
               findPaths(maze, r, c + 1, path + "R", visited, ans);
          }

          // Move Up
          if (isSafe(maze, r - 1, c, visited)) {
               findPaths(maze, r - 1, c, path + "U", visited, ans);
          }

          // BACKTRACK: Unmark this cell as visited for other potential paths
          visited[r][c] = false;
     }

     public static boolean isSafe(int[][] maze, int r, int c, boolean[][] visited) {
          int n = maze.length;
          return (r >= 0 && r < n && c >= 0 && c < n && maze[r][c] == 1 && !visited[r][c]);
     }

     public static void main(String[] args) {
          int maze[][] = {
                    { 1, 0, 0, 0 },
                    { 1, 1, 0, 1 },
                    { 1, 1, 0, 0 },
                    { 0, 1, 1, 1 }
          };

          ArrayList<String> ans = new ArrayList<>();
          int n = maze.length;

          // Ensure starting point is not blocked
          if (maze[0][0] == 1) {
               boolean[][] visited = new boolean[n][n];
               findPaths(maze, 0, 0, "", visited, ans);
          }

          if (ans.isEmpty()) {
               System.out.println("No path found");
          } else {
               System.out.println("Total Paths: " + ans.size());
               for (String path : ans) {
                    System.out.println(path);
               }
          }
     }
}
