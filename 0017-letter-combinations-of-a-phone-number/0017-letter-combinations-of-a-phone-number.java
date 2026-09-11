import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int index, String digits, StringBuilder current, List<String> result) {
        // Base case: jab saare digits process ho jayein
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Current digit ke mapped characters nikalo
        int digit = digits.charAt(index) - '0';
        String letters = KEYPAD[digit];

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));       // Choose
            backtrack(index + 1, digits, current, result); // Explore
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}