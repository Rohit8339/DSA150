class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0;  i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(f(0, i, j, board, word, n, m)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    boolean f(int i, int r, int c, char[][] board, String word, int n, int m) {
        if(i == word.length()) {
            return true;
        }

        if(r < 0 || r >= n || c < 0 || c >= m || board[r][c] != word.charAt(i)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = ' ';

        boolean found = (f(i + 1, r - 1, c, board, word, n, m) || 
                         f(i + 1, r, c + 1, board, word, n, m) ||
                         f(i + 1, r + 1, c, board, word, n, m) || 
                         f(i + 1, r, c - 1, board, word,  n, m));
        
        board[r][c] = temp;

        return found;
    }
}