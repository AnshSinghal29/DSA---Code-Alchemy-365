class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        // Advance until fast hits 1 or slow and fast meet in a cycle
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }
}