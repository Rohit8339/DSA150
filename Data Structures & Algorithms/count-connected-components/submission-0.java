class Solution {
    public int countComponents(int n, int[][] edges) {

        int e = edges.length;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)  {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i <  e; i++)  {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int count = 0;

        boolean[] visited =  new boolean[n];

        for(int i = 0;  i  < n;  i++) {
            if(!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }

        return count;

    }

    void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node]  = true;

        List<Integer> neighbours = adj.get(node);
        for(int i = 0; i < neighbours.size(); i++) {
            int neighbourNode = neighbours.get(i);
            if(!visited[neighbourNode]) {
                dfs(neighbourNode, adj, visited);
            }
        }
    }
}
