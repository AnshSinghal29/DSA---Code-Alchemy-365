
import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        int ans = 1;
        int prev = Integer.MIN_VALUE;

        // dp0: sequence ending at previous number
        // dp1: sequence ending at previous number + 1
        int dp0 = 1;
        int dp1 = 1;

        for (int num : nums) {

            if (num == prev) {
                dp1 = dp0 + 1;
            }
            else if (num == prev + 1) {
                dp0++;
                dp1++;
            }
            else if (num == prev + 2) {
                dp0 = dp1 + 1;
                dp1 = 1;
            }
            else {
                dp0 = 1;
                dp1 = 1;
            }

            ans = Math.max(ans, Math.max(dp0, dp1));
            prev = num;
        }

        return ans;
    }
}
