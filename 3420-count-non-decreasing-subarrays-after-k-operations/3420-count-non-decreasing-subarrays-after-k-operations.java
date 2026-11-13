
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<int[]> dq = new ArrayDeque<>();

        long ans = 0;
        long cost = 0;

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Maintain decreasing order
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] p = dq.pollLast();

                cost += (long) (num - p[0]) * p[1];

                count += p[1];
            }

            dq.offerLast(new int[]{num, count});

            // Reduce window if cost exceeds k
            while (cost > k) {

                int[] p = dq.pollFirst();

                cost -= (long) (p[0] - nums[j]);

                if (p[1] > 1) {
                    dq.offerFirst(new int[]{p[0], p[1] - 1});
                }

                j--;
            }

            // Count valid subarrays
            ans += j - i + 1;
        }

        return ans;
    }
}
