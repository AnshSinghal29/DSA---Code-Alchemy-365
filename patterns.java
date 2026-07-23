public class patterns {

     public static void hollow_Rectangle(int totRows, int totCols) {
          // outer loop for rows
          for (int i = 1; i <= totRows; i++) {
               // inner loop for column
               for (int j = 1; j <= totCols; j++) {
                    if (i == 1 || i == totRows || j == 1 || j == totCols) {
                         System.out.print("*");
                    } else {
                         System.out.print(" ");
                    }
               }
               System.out.println();
          }
     }

     public static void inverted_rotated_half_pyramid(int n) {
          for (int i = 1; i <= n; i++) {
               // for spaces
               for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
               }
               // for stars
               for (int j = 1; j <= i; j++) {
                    System.out.print("*");
               }
               System.out.println();
          }
     }

     public static void inverted_half_pyramid(int n) {
          for (int i = 1; i <= n; i++) {
               // inner-numbers
               for (int j = 1; j <= n - i + 1; j++) {
                    System.out.print(j + " ");
               }
               System.out.println();
          }
     }

     public static void floyds_traingle(int n) {
          // outer
          int counter = 1;
          for (int i = 1; i <= n; i++) {
               // how many times the counter be printed
               for (int j = 1; j <= i; j++) {
                    System.out.print(counter + " ");
                    counter++;
               }
               System.out.println();
          }
     }

     public static void zero_one_triangle(int n) {
          // outer
          for (int i = 1; i <= n; i++) {
               // sum of rows and coloumn to print either 1 or 0
               for (int j = 1; j <= i; j++) {
                    if ((i + j) % 2 == 0) {
                         System.out.print("1");
                    } else {
                         System.out.print("0");
                    }
               }
               System.out.println();
          }
     }

     public static void buttefly(int n) {
          // 1st half
          for (int i = 1; i <= n; i++) {
               // stars-i
               for (int j = 1; j <= i; j++) {
                    System.out.print("*");
               }
               // spaces - 2(n-i)
               for (int j = 1; j <= 2 * (n - i); j++) {
                    System.out.print(" ");
               }
               // starts-i
               for (int j = 1; j <= i; j++) {
                    System.out.print("*");
               }
               System.out.println();

          }
          // 2nd half
          for (int i = n; i >= 1; i--) {
               // stars-i
               for (int j = 1; j <= i; j++) {
                    System.out.print("*");
               }
               // spaces - 2(n-i)
               for (int j = 1; j <= 2 * (n - i); j++) {
                    System.out.print(" ");
               }
               // starts-i
               for (int j = 1; j <= i; j++) {
                    System.out.print("*");
               }
               System.out.println();

          }
     }

     public static void solid_rhombus(int n) {
          // outer loop
          for (int i = 1; i <= n; i++) {
               // spaces
               for (int j = 1; j <= (n - i); j++) {
                    System.out.print(" ");
               }
               // stars
               for (int j = 1; j <= n; j++) {
                    System.out.print("*");
               }
               System.out.println();
          }
     }

     public static void main(String args[]) {

          // hollow_Rectangle(4, 5);
          // inverted_rotated_half_pyramid(5);
          // inverted_half_pyramid(5);
          // floyds_traingle(5);
          // zero_one_triangle(5)
          // buttefly(4);
          solid_rhombus(4);
     }
}
