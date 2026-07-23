import java.util.*;

public class LinearASearch {
     public static int linear(int[] arr, int key, int n) {
          for (int i = 0; i < n; i++) {
               if (arr[i] == key) {
                    return i;
               }
          }
          return -1;
     }
}

public static void main(String args[]) {
     int arr[] = { 1, 2, 3, 4, 5 };
     int n = arr.length;
     System.out.println(linear(arr, 5, n));
}