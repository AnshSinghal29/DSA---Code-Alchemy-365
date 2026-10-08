import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        // Deque to store indices of array elements
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Step 1: Remove indices that are out of the current sliding window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Step 2: Remove elements from the back that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Step 3: Add current element index to the back
            deque.offerLast(i);

            // Step 4: Record the maximum for the current window once the first window is formed
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}