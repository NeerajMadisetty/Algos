class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Graph g = new Graph(n);
        
        for(int i=0; i<times.length; i++){
            g.addEdge(times[i][0]-1,times[i][1]-1,times[i][2]);
        }
        if(g.findAllShortestPaths(k-1)) return Arrays.stream(g.dist).max().getAsInt();
        return -1;
    }
    
    class Graph{
        
        int n;
        boolean[] visited;
        LinkedList[] adj;
        int[] dist;
        
        Graph(int n){
            this.n = n;
            visited = new boolean[n];
            adj = new LinkedList[n];
            dist = new int[n];
            
            for(int  i=0; i<n; i++){
                adj[i] = new LinkedList<int[]>();
            }
            
            Arrays.fill(dist,Integer.MAX_VALUE);
         }
        
        void addEdge(int u, int v, int k){
            adj[u].add(new int[]{v,k});
        }
        
        boolean findAllShortestPaths(int k){
            
            dist[k] = 0;
            for(int i=0; i<n; i++){
                int v = findMin();
                if(v == -1) return false;
                updateNeighbors(v);
                visited[v]  = true;
            }
            
            return true;
        }
        
        int findMin(){
            
            int minVertex = -1;
            int minDist = Integer.MAX_VALUE;
            
            for(int i=0; i<n; i++){
                
                if(!visited[i] && dist[i] < minDist){
                    minDist = dist[i];
                    minVertex = i;
                }
            }
            
            return minVertex;
        }
        
        void updateNeighbors(int u){
            
            LinkedList<int[]> edges = adj[u];
            
            for(int[] edge: edges){
                
                int v = edge[0];
                int w = edge[1];
                
                if(dist[u] + w < dist[v]) dist[v] = dist[u]+w;
            }
        }
        
        
    }
}
