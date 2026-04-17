class BackTrackingArray {
     public static void chngArray(int arr[], int i, int val) {
          // base Case
          if (i == arr.length) {
               printArr(arr);
               return;
          }
          // kaam
          arr[i] = val; // value assign krna
          chngArray(arr, i + 1, val + 1);// stack me upr badhte hue call lagana
          arr[i] = arr[i] - 2;// niche vapas aana
     }

     public static void printArr(int arr[]) {
          for (int i = 0; i < arr.length; i++) {
               System.out.println(arr[i] + " ");
          }
          System.out.println(" ");
     }

     public static void main(String[] args) {
          int arr[] = new int[5];
          chngArray(arr, 0, 1);
          printArr(arr);
     }
}