public class maxsubarraysumopt {
     public static void prefixarraysum(int numbers[]) {
          int currSum = 0;
          int maxSum = Integer.MIN_VALUE;
          int prefix[] = new int[numbers.length];

          prefix[0] = numbers[0];

          // calculate prefix array
          for (int i = 1; i < prefix.length; i++) {
               prefix[i] = prefix[i - 1] + numbers[i];
          }

          for (int i = 0; i < numbers.length; i++) {
               int start = i;

               for (int j = 0; j < numbers.length; j++) {
                    int end = j;
                    currSum = 0;

                    currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                    for (int k = start; k <= end; k++) {
                         if (maxSum < currSum) {
                              maxSum = currSum;
                         }
                    }                  
               }
          }
          System.out.println("MAX SUM =" + maxSum);

     }

     public static void main(String args[]) {
          int numbers[] = { 1, -2, 6, -1, 3 };
          prefixarraysum(numbers);
     }

}
