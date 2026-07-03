class Solution {
    int[] delrow = {-1, 0, 1, 0};
    int[] delcol = {0, 1, 0, -1};

    void dfs(int row, int col, int[][] visited, char[][] board) {
        visited[row][col] = 1;

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                visited[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, visited, board);
            }
        }
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] visited = new int[rows][cols];

        // Traverse first and last row
        for (int j = 0; j < cols; j++) {
            if (visited[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, visited, board);
            }

            if (visited[rows - 1][j] == 0 && board[rows - 1][j] == 'O') {
                dfs(rows - 1, j, visited, board);
            }
        }

        // Traverse first and last column
        for (int i = 0; i < rows; i++) {
            if (visited[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, visited, board);
            }

            if (visited[i][cols - 1] == 0 && board[i][cols - 1] == 'O') {
                dfs(i, cols - 1, visited, board);
            }
        }

        // Replace unvisited 'O' with 'X'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}