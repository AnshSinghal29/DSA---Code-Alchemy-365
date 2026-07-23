public class primeno {

     public static boolean isPrime(int n){
          boolean isPrime = true;
          for(int i = 2; i<=Math.sqrt(n); i++){
               if(n % i == 0){
                    isPrime = false;
                    break;
               }
          }
          return isPrime;
     }

     public static void primesinRange(int n){
          for(int i=0;i<=n;i++){
               if(isPrime(i)){
                    System.out.println((i +" "));
               }
          }System.out.println();
     }
     public static void main(String args[])
     {
     primesinRange(30);
     }
}
         
