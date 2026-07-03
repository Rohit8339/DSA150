
class Solution { 
    class Pair { 
        int node; 
        int wt; 
        Pair(int node, int wt) { 
            this.node = node; 
            this.wt = wt; 
        } 
    } 

    public int networkDelayTime(int[][] times, int n, int k) { 
        int e = times.length; 
        
        
        List<List<Pair>> adj = new ArrayList<>(); 
        for(int i = 0; i <= n; i++) { 
            adj.add(new ArrayList<>()); 
        } 
        
        
        for(int i = 0; i < e; i++) { 
            int u = times[i][0]; 
            int v = times[i][1]; 
            int wt = times[i][2]; 
            adj.get(u).add(new Pair(v, wt)); 
        } 

        int[] distance = new int[n + 1]; 
        Arrays.fill(distance, Integer.MAX_VALUE); 
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt); 
        
        pq.add(new Pair(k, 0)); 
        distance[k] = 0; 

        while(!pq.isEmpty()) { 
            Pair top = pq.poll(); 
            int u = top.node; 
            int wt = top.wt; 
            
            if (wt > distance[u]) continue;

            List<Pair> neighbours = adj.get(u); 
            for(int i = 0; i < neighbours.size(); i++) { 
                int neighbourNode = neighbours.get(i).node; 
                int neighbourNodeWt = neighbours.get(i).wt; 
                
                if(wt + neighbourNodeWt < distance[neighbourNode]) { 
                    distance[neighbourNode] = wt + neighbourNodeWt; 
                    pq.add(new Pair(neighbourNode, distance[neighbourNode])); 
                } 
            } 
        } 

        int maxi = -1; 
        for(int i = 1; i <= n; i++) { 
            if(distance[i] == Integer.MAX_VALUE) return -1; 
            else maxi = Math.max(maxi, distance[i]); 
        } 
        return maxi; 
    } 
}
