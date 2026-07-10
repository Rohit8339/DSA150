
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int result = f(n - 1, amount, coins, dp);

        return result >= 1e9 ? -1 : result;
    }

    int f(int i, int amount, int[] coins, int[][] dp) {
        if (amount == 0) return 0;
        

        if (i == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return (int) 1e9; 
        }

        if (dp[i][amount] != -1) return dp[i][amount];

        int notPick = f(i - 1, amount, coins, dp);
        
        int pick = (int) 1e9;
        if (amount >= coins[i]) {
            pick = 1 + f(i, amount - coins[i], coins, dp);
        }

        return dp[i][amount] = Math.min(pick, notPick);
    }
}
