
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int minPrice = Integer.MAX_VALUE;

        // Find cheapest item
        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        // DP initialization
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1000000);
        dp[0] = 0;

        // Process each item type
        for (int i = 0; i < n; i++) {

            int factor = items[i][0];
            int price = items[i][1];

            // Count free items
            int freeCount = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factor == 0) {
                    freeCount++;
                }
            }

            // First purchase gives itself + free items
            int gain = freeCount + 1;

            // 0/1 Knapsack
            for (int j = budget; j >= price; j--) {

                if (dp[j - price] != -1000000) {
                    dp[j] = Math.max(
                        dp[j],
                        dp[j - price] + gain
                    );
                }
            }
        }

        // Spend remaining budget on cheapest item
        int ans = 0;

        for (int j = 0; j <= budget; j++) {

            if (dp[j] != -1000000) {
                int total = dp[j] + (budget - j) / minPrice;
                ans = Math.max(ans, total);
            }
        }

        return ans;
    }
}
