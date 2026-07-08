
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 1, n, prices, dp);
    }

    int f(int i, int buy, int n, int[] prices, int[][] dp) {

        if (i >= n) return 0;

        if (dp[i][buy] != -1) return dp[i][buy];

        int profit = 0;

        if (buy == 1) {
            
            profit = Math.max(-prices[i] + f(i + 1, 0, n, prices, dp), 
                                          f(i + 1, 1, n, prices, dp));
        } else {
            
            profit = Math.max(prices[i] + f(i + 2, 1, n, prices, dp), 
                                         f(i + 1, 0, n, prices, dp));
        }

        return dp[i][buy] = profit;
    }
}
