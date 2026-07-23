// public class basicpattern1 {
     // *
     // **
     // ***
     // ****
//      public static void main(String args[]){
//          for(int line = 1; line <= 4; line++){
//           for(int star = 1; star<=line; star++)
//           {
//                System.err.print("*");
//           }
//           System.err.println();
//          }
//      }
// }

public class basicpattern1 {
     
     public static void main(String args[]){
         for(int line = 1; line <= 4; line++){
          for(int star = 1; star<4-line+1; star++)
          {
               System.err.print("*");
          }
          System.err.println();
         }
     }
}

