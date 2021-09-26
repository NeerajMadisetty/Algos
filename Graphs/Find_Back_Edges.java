class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
         Graph g = new Graph(numCourses);
        
         int[] indegree = new int[numCourses];
        
        if(prerequisites.length == 0) return true;
        
        for(int i=0; i<prerequisites.length; i++){
             if(prerequisites[i][0] == prerequisites[i][1]){
                 return false;
             }
            indegree[prerequisites[i][0]]++;
        }
        int vertex = -1;
        
        
        
        for(int i=0;i<prerequisites.length;i++){
            g.addEdge(prerequisites[i][1],prerequisites[i][0]);
        }
        
        boolean isPossible = true;

        // for(int i=0; i<numCourses; i++){
        //     if(indegree[i]==0){
        //         vertex = i;
        //         isPossible = g.DFS(vertex);
        //         if(!isPossible){
        //             return false;
        //         }
        //     }
        // }
        
        for(int i=0; i<g.noOfVertices; i++){
            if(g.visited[i] == 0) {
                isPossible = g.DFSUtil(i);
                 if(!isPossible){
                       return false;
                }
            }
        }
        
        return true;
        
    }
    
    class Graph {
	
	private int noOfVertices;
	private LinkedList[] adj;
    public  int[] visited;
	
	Graph(int v){
		noOfVertices= v;
		adj = new LinkedList[v];
        visited = new int[noOfVertices];
		for(int i=0;i<adj.length;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
	
	// boolean DFS(int v) {
	// for()
	// 	return DFSUtil(v);
	// }
	
	boolean DFSUtil(int v) {
        visited[v] =1;
        LinkedList<Integer> edges = adj[v];
        
        for(Integer i: edges){
            //System.out.println("Visited for "+i+" is "+visited[i]);
            if(visited[i] == 1) return false;
            if(visited[i] == 0) {
                if(!DFSUtil(i)) return false;
            }
        }
        visited[v] = 2;
        return true;
	
    }
        
    // boolean allVisited(){
    //     for(int i=0; i<visited.length; i++){
    //         if(!visited[i] != 0) return false;
    //     }
    //     return true;
    // }
        

}
}