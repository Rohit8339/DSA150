class Solution { 
    public boolean canPartition(int[] nums) { 
        int n = nums.length; 
        int totalSum = 0; 
        for(int i = 0; i < n; i++) { 
            totalSum += nums[i]; 
        } 
        if(totalSum % 2 != 0) return false; 
        
        Boolean[][] dp = new Boolean[n][totalSum/2 + 1]; 
        return f(0, totalSum/2, n, nums, dp); 
    } 
    
    boolean f(int i, int sum, int n, int nums[], Boolean[][] dp) { 
        if(sum == 0) return true; 
        if(i == n - 1) return (sum == nums[i]); 
        
        if(dp[i][sum] != null) return dp[i][sum]; 
        
        boolean pick = false; 
        if(sum >= nums[i]) { 
            pick = f(i+1, sum - nums[i], n, nums, dp); 
        } 
        boolean notPick = f(i + 1, sum, n, nums, dp); 
        
        return dp[i][sum] = pick || notPick; 
    } 
}
