
class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if (edges.length != n - 1) return false;

        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        
        boolean[] visited = new boolean[n];
        int visitedCount = dfs(0, adj, visited);

        
        return visitedCount == n;
    }

    private int dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        int count = 1; 

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, adj, visited);
            }
        }
        return count;
    }
}
