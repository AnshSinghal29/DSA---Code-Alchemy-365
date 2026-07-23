public class StaircaseSearch {
     public static boolean Searchkey(int matrix[][], int key) {
          int row = 0, col = matrix[0].length - 1; // (m-1)
          while (row < matrix.length && col >= 0) {
               if (matrix[row][col] == key) {
                    System.out.print("Key found at (" + row + "," + col + ")");
                    return true;
               } else if (key < matrix[row][col]) {
                    col--;
               } else {
                    row++;
               }
          }
          System.out.print("Key does not exist");
          return false;
     }

     public static void main(String args[]) {
          int matrix[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 25, 29, 37, 48 }, { 32, 33, 39, 50 } };
          int key = 33;
          Searchkey(matrix, key);
     }
}