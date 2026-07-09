class Solution {
    //int mod = 1_000_000_007;
    public int change(int amount, int[] coins) {
        int n =  coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(n - 1, amount, coins, dp);
    }
    
    private int f(int i, int amount, int[] coins, int[][] dp) {

        if (amount == 0) return 1;

        if (i == 0) {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }

        if (dp[i][amount] != -1) return dp[i][amount];

        int pick = 0;
        if (amount >= coins[i]) {
            pick = f(i, amount - coins[i], coins, dp);
        }

        int notPick = f(i - 1, amount, coins, dp);

        return dp[i][amount] = (pick + notPick) ;
    }
    
}
