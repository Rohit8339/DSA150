class Solution {
    public int lengthOfLIS(int[] nums) {


        int n = nums.length;

        int dp[][] = new int[n][n+1];
        for(int i = 0; i  < n; i++) {
            Arrays.fill(dp[i],  -1);
        }

        return f(0, -1, n, nums, dp);
        
    }

    int f(int i, int prev, int n, int nums[],  int[][] dp) {

        if(i == n - 1) {
            if(prev == -1 || nums[prev] < nums[i]) return 1;
            return 0;
        }

        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        int notPick = f(i+1, prev, n,  nums, dp);

        int pick = 0;
        if(prev == -1 || nums[prev] < nums[i]) {
            pick  = 1 + f(i+1, i, n, nums, dp);
        }

        return dp[i][prev+1] = Math.max(pick, notPick);
    }
}
