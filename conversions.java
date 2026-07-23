public class conversions {
     public static void binTodec(int binNum) {
          int pow = 0;
          int MyNum = binNum;
          int decNum = 0;

          while (binNum > 0) {
               int LastDigit = binNum % 10;
               decNum = decNum + (LastDigit * (int) Math.pow(2, pow));

               pow++;
               binNum = binNum / 10;
          }
          System.out.println("decimal of" + MyNum + "=" + decNum);
     }

     public static void decTobin(int decNum) {
          int pow = 0;
          int Mynum = decNum;
          int binNum = 0;

          while (decNum > 0) {
               int rem = decNum % 2;
               binNum = binNum + (rem * (int) Math.pow(10, pow));

               pow++;
               decNum = decNum / 2;
          }
          System.out.println("binary form of" + decNum + "=" + binNum);
     }

     public static void main(String args[]) {
          decTobin(5);
     }
}
