class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;

        // Keep scanning until we hit the end of either string
        while (sPointer < s.length() && tPointer < t.length()) {
            
            // If the characters match, we successfully found a piece of 's'.
            // Move the sPointer to look for the next character.
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            
            // No matter what, we always move forward in 't' to keep searching.
            tPointer++;
        }

        // If we found every character in 's', the sPointer will have been 
        // incremented exactly s.length() times.
        return sPointer == s.length();
    }
}