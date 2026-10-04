class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: Overflow condition
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Sign determine karo (agar ek negative hai to result negative hoga)
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Long mein convert karo taaki absolute values safely handle ho sakein
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        while (dvd >= dvs) {
            long tempDvs = dvs;
            long multiple = 1;

            // Divisor ko double karte jao jab tak wo dividend se chhota ho
            while (dvd >= (tempDvs << 1)) {
                tempDvs <<= 1;
                multiple <<= 1;
            }

            // Quotient mein add karo aur remainder par bacha hua kaam karo
            dvd -= tempDvs;
            quotient += multiple;
        }

        return isNegative ? -quotient : quotient;
    }
}