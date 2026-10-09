class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        
        // Find the maximum pile size for the upper bound of binary search
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int minSpeed = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                minSpeed = mid;   // Valid speed, try to find a smaller one on the left
                right = mid - 1;
            } else {
                left = mid + 1;   // Too slow, need a higher speed
            }
        }

        return minSpeed;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }
}