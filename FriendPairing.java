public class FriendPairing {
     public static int FriendPairingProblem(int n) {
          // BC
          if (n == 1 || n == 2) {
               return n;
          }
          // choice
          // single
          int fnm1 = FriendPairingProblem(n - 1);

          // pair
          int fnm2 = FriendPairingProblem(n - 2);
          int pairWays = (n - 1) * fnm2;

          // total ways
          int totWay = fnm1 + pairWays;
          return totWay;
     }

     public static void main(String[] args) {
          System.out.println(FriendPairingProblem(3));
     }
}
