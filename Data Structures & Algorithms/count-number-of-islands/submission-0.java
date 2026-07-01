class Solution { 
    public int numIslands(char[][] grid) { 
        int rows = grid.length; 
        int cols = grid[0].length; 
        boolean visited[][] = new boolean[rows][cols]; 
        int islands = 0; 
        
        
        for(int i = 0; i < rows; i++) { 
            for(int j = 0; j < cols; j++) { 
                if(grid[i][j] == '1' && visited[i][j] == false) { 
                    islands++; 
                    dfs(i, j, rows, cols, grid, visited); 
                } 
            } 
        } 
        return islands; 
    } 

    void dfs(int r, int c, int rows, int cols, char[][] grid, boolean[][] visited) { 
        visited[r][c] = true; 
        
        int[] dr = {0, 1, -1, 0}; 
        int[] dc = {1, 0, 0, -1}; 
        
        for(int i = 0; i < 4; i++) { 
            int newR = r + dr[i]; 
            int newC = c + dc[i]; 
            
            if(newR < 0 || newR >= rows || newC < 0 || newC >= cols || visited[newR][newC] == true || grid[newR][newC] == '0') {
                continue; 
            } else { 
                dfs(newR, newC, rows, cols, grid, visited); 
            } 
        } 
    } 
}
