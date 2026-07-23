public class diagonalSum {
    public static int diagonalsum(int matrix[][]){
        int sum = 0;

     //    Approch 1 (brute force with time complexity O(n2))
     //    for(int i = 0;i<matrix.length;i++){
     //      for(int j = 0;j<matrix[0].length - 1;j++){
     //           if(i==j){
     //                sum+=matrix[i][j];
     //           }
     //           else if(i + j == matrix.length-1){
     //                sum+=matrix[i][j];
     //           }
     //      }
     //    }

        //OPTIMISED APPROACH
        for(int i = 0; i < matrix.length; i++){
            // Primary diagonal
            sum += matrix[i][i];

            // Secondary diagonal
            // This condition prevents double-adding the center element in odd-sized matrices
            if(i != matrix.length-1-i) {
                sum += matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }

     public static void main(String args[]) {
          int matrix[][] = {
                    { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 },
                    { 9, 10, 11, 12 },
                    { 13, 14, 15, 16 }
          };

          // Option 1: Store the result in a variable and then print it
          int result = diagonalsum(matrix);
          System.out.println("The diagonal sum is: " + result);

          // Option 2: Print the result directly (a shorter way to do the same thing)
          // System.out.println(diagonalsum(matrix));
     }
}
