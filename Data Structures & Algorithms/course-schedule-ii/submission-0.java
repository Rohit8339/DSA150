
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); 
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, adj, visited, pathVisited, stack)) {
                    return new int[0]; 
                }
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, boolean[] visited, 
                             boolean[] pathVisited, Stack<Integer> stack) {
        
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, adj, visited, pathVisited, stack)) {
                    return true;
                }
            } 
            
            else if (pathVisited[neighbor]) {
                return true;
            }
        }

        stack.push(node);

        pathVisited[node] = false;
        return false;
    }
}
