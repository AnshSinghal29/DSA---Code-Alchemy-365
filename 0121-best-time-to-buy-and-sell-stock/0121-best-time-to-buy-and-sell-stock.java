class Solution {
    public int maxProfit(int[] prices) {
         int buyprice = Integer.MAX_VALUE;
          int mp = 0;

          for (int i = 0; i < prices.length; i++) {
               if (buyprice < prices[i]) { // profit
                    int profit = prices[i] - buyprice; /// today's profit
                    mp = Math.max(mp, profit);
               } else {
                    buyprice = prices[i];
               }
          }
          return mp;
    }
}