
class Solution {
    class Tuple {
        int r;
        int c;
        int time;

        Tuple(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Tuple> q = new LinkedList<>();
        
        int freshCount = 0; 

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Tuple(i, j, 0));
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        
        if (freshCount == 0) return 0;

        int totalTime = 0;
        
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        
        while (!q.isEmpty()) {
            Tuple top = q.poll();
            int currR = top.r;
            int currC = top.c;
            int time = top.time;
            
            totalTime = time; 

            for (int k = 0; k < 4; k++) {
                int newR = currR + dr[k];
                int newC = currC + dc[k];

                
                if (newR < 0 || newR >= rows || newC < 0 || newC >= cols || 
                    visited[newR][newC] || grid[newR][newC] == 0) {
                    continue;
                }

               
                if (grid[newR][newC] == 1) {
                    grid[newR][newC] = 2; 
                    freshCount--;         
                    visited[newR][newC] = true;
                    q.add(new Tuple(newR, newC, time + 1));
                }
            }
        }

        return (freshCount == 0) ? totalTime : -1;
    }
}
