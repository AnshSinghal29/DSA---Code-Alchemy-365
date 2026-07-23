import java.util.*;

public class DemoLeetcode {
     public static void main(String args[]) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter 1st number");
          int a = sc.nextInt();
          System.out.println("Enter 2nd number");
          int b = sc.nextInt();
          int count = 0;

          int curr = 0;
          for (int i = a; i <= b; i++) {

               if (i % 3 == 0) {
                    int sum = 0;
                    int temp = i;
                    while (temp > 0) {
                         sum += temp % 10;
                         temp = temp / 10;
                    }
                    if (sum % 2 == 0) {
                         count++;
                    }

               }

          }
          System.out.println(count);
     }
}