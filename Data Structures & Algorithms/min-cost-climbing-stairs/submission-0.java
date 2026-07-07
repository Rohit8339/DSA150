class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return Math.min(f(0, n, cost, dp), f(1, n, cost, dp));
    }

    int f(int i, int n, int[] cost, int[] dp) {

        if (i >= n) return 0; 
        
        if (dp[i] != -1) return dp[i];
        
        return dp[i] = cost[i] + Math.min(f(i + 1, n, cost, dp), f(i + 2, n, cost, dp));
    }
}
