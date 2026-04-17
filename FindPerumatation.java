
public class FindPerumatation {
     public static void FindPum(String str, String ans) {
          // base case
          if (str.length() == 0) {
               System.out.println(ans);
               return;
          }
          // recursion
          for (int i = 0; i < str.length(); i++) {
               char curr = str.charAt(i);
               // "abcde" -> "ab" + "de" -> "abde" == removed c by adding substrings
               String newstr = str.substring(0, i) + str.substring(i + 1);
               FindPum(newstr, ans + curr);
          }
     }

     public static void main(String[] args) {
          String str = "abc";
          FindPum(str, "");
     }
}
