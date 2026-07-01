

class Solution {
    class Tuple {
        int r;
        int c;
        int dist;

        Tuple(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        Queue<Tuple> q = new LinkedList<>(); 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Tuple(i, j, 0));
                    visited[i][j] = true; 
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Tuple top = q.poll();
            int r = top.r;
            int c = top.c;
            int dist = top.dist;

            grid[r][c] = dist;

            for (int k = 0; k < 4; k++) {
                int newR = r + dr[k];
                int newC = c + dc[k];

                if (newR < 0 || newR >= rows || newC < 0 || newC >= cols || 
                    visited[newR][newC] || grid[newR][newC] == -1) {
                    continue;
                }

                visited[newR][newC] = true; 
                q.add(new Tuple(newR, newC, dist + 1));
            }
        }
    }
}
