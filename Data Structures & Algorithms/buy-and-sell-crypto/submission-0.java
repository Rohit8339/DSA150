class Solution {
    public int maxProfit(int[] prices) {

        /*O[n^2]

        int n  = prices.length;
        int maxProfit = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        */

        int n = prices.length;
        int maxProfit  = 0;
        int minBuy = prices[0];

        for(int i = 1; i < n; i++)  {
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }

        return maxProfit;
        
    }
}
