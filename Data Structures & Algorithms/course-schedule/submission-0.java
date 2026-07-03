
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); 
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, adj, visited, pathVisited)) {
                    return false; 
                }
            }
        }
        return true; 
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
           
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, adj, visited, pathVisited)) {
                    return true;
                }
            } 
            
            else if (pathVisited[neighbor]) {
                return true;
            }
        }

        
        pathVisited[node] = false;
        return false;
    }
}
