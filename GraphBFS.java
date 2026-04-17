import java.util.*;

public class GraphBFS {

     public static void bfs(ArrayList<ArrayList<Integer>> adj, int start) {
          int n = adj.size();
          boolean[] visited = new boolean[n];
          Queue<Integer> queue = new LinkedList<>();

          visited[start] = true;
          queue.add(start);

          while (!queue.isEmpty()) {
               int node = queue.poll();
               System.out.print(node + " ");

               for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                         visited[neighbor] = true;
                         queue.add(neighbor);
                    }
               }
          }
     }

     public static void main(String[] args) {
          int n = 6;
          ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

          for (int i = 0; i < n; i++) {
               adj.add(new ArrayList<>());
          }

          adj.get(0).add(1);
          adj.get(0).add(2);
          adj.get(1).add(0);
          adj.get(1).add(3);
          adj.get(1).add(4);
          adj.get(2).add(0);
          adj.get(2).add(5);
          adj.get(3).add(1);
          adj.get(4).add(1);
          adj.get(5).add(2);

          bfs(adj, 0);
     }
}