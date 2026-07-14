class Solution {
    int mod = 1_000_000_007;

    public int numDistinct(String s, String t) {
        
    int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <  n;  i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(n - 1, m - 1, s, t, dp);
    }

    int f(int i, int j, String s, String t,  int[][] dp) {
        if (j < 0) return 1; 
        if (i < 0) return 0; 

        if(dp[i][j]  != -1) return dp[i][j];
        
        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            int leave = f(i - 1, j - 1, s, t, dp);
            int stay = f(i - 1, j, s, t, dp);
            result = (leave + stay) % mod;
        } else {
            result = f(i - 1, j, s, t, dp);
        }
        return dp[i][j] = result;
    }
}
