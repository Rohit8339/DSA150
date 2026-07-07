class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for(int i = 0; i <  m;  i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(0, 0, m, n, dp);
        
    }

    int f(int i, int j, int rows, int cols, int[][] dp) {

        if(i < 0 || i >= rows || j < 0 || j >= cols) return 0;

        if(i == rows - 1 && j == cols - 1) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int down = f(i+1, j, rows, cols, dp);
        int right = f(i, j + 1, rows, cols, dp);

        return dp[i][j] = down + right;
    }
}