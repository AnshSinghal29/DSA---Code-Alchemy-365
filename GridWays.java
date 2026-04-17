public class GridWays {
     public static int gridWay(int i, int j, int n, int m) {
          // base case
          if (i == n - 1 && j == m - 1)// last cell condn
          {
               return 1;
          } else if (i == n || j == n) {// boundry cross condn
               return 0;
          }

          // recursion]
          int w1 = gridWay(i + 1, j, n, m);// down
          int w2 = gridWay(i, j + 1, n, m);// right
          return w1 + w2;
     }

     public static void main(String[] args) {
          int n = 3;
          int m = 3;
          System.out.println(gridWay(0, 0, n, m));
     }
}
