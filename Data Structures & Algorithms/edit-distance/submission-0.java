class Solution {
    public int minDistance(String start, String target) {
        int n = start.length();
        int m = target.length();

        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i  <n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(n - 1, m - 1, start, target, dp);
    
    }

    int f(int i, int j, String start, String target,  int[][] dp) {
        if (i < 0) return j + 1; 
        
        if (j < 0) return i + 1; 

        if(dp[i][j] != -1) return dp[i][j];

        if (start.charAt(i) == target.charAt(j)) {
            return f(i - 1, j - 1, start, target,  dp);
        } else {
            int insertOp  = 1 + f(i, j - 1, start, target, dp);
            int deleteOp  = 1 + f(i - 1, j, start, target, dp);
            int replaceOp = 1 + f(i - 1, j - 1, start, target, dp);
            
            return dp[i][j] = Math.min(insertOp, Math.min(deleteOp, replaceOp));
        }
    }
}


        