import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        // Agar length odd hai to pairs kabhi ban hi nahi sakte
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // Closing bracket case:
                // Stack empty ho ya expected bracket match na kare
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // Saare brackets properly match ho chuke hone chahiye
        return stack.isEmpty();
    }
}