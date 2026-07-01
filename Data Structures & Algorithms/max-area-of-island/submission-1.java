

class Solution { 
    public int maxAreaOfIsland(int[][] grid) { 
        int rows = grid.length; 
        int cols = grid[0].length; 
        
        int maxArea = 0; 
        
        boolean visited[][] = new boolean[rows][cols]; 
        
        for(int i = 0; i < rows; i++) { 
            for(int j = 0; j < cols; j++) { 
                if(grid[i][j] == 1 && visited[i][j] == false) { 
                    maxArea = Math.max(maxArea, dfs(i, j, rows, cols, grid, visited)); 
                } 
            } 
        } 
        return maxArea;
    } 

    int dfs(int r, int c, int rows, int cols, int[][] grid, boolean[][] visited) { 
        visited[r][c] = true; 
        
        int currentIslandArea = 1;
        
        int[] dr = {0, 1, -1, 0};
        int[] dc = {1, 0, 0, -1};
        
        for(int k = 0; k < 4; k++) { 
            int newR = r + dr[k]; 
            int newC = c + dc[k]; 
            
            if(newR < 0 || newR >= rows || newC < 0 || newC >= cols || visited[newR][newC] == true || grid[newR][newC] == 0) { 
                continue; 
            } else { 
                currentIslandArea += dfs(newR, newC, rows, cols, grid, visited); 
            } 
        } 
        
        return currentIslandArea;
    } 
}
