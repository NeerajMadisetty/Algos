class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Graph g = new Graph(numCourses);
        int[] result = new int[numCourses];
        
        for(int i=0; i<numCourses; i++){
            result[i] = numCourses-i-1;
        }
        
        if(prerequisites.length == 0) return result;
        
        
        for(int i=0;i<prerequisites.length;i++){
            g.addEdge(prerequisites[i][1],prerequisites[i][0]);
        }
        
        boolean isPossible = true;


        for(int i=0; i<g.noOfVertices; i++){
            if(g.visited[i] == 0) {
                isPossible = g.DFSUtil(i);
                 if(!isPossible){
                       return new int[0];
                }
            }
        }
        
        
        for(int i=0; i<numCourses; i++){
            result[i] = g.order.pop();
        }
        
        
        return result;
        
    }
    
    
    class Graph {
	
	private int noOfVertices;
	private LinkedList[] adj;
    public  int[] visited;
    Stack<Integer> order;
        
	Graph(int v){
		noOfVertices= v;
		adj = new LinkedList[v];
        visited = new int[noOfVertices];
        order = new Stack<>();
		for(int i=0;i<adj.length;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
	
	boolean DFSUtil(int v) {
        visited[v] =1;
        LinkedList<Integer> edges = adj[v];
        
        for(Integer i: edges){
            if(visited[i] == 1) return false;
            if(visited[i] == 0) {
                if(!DFSUtil(i)) return false;
            }
        }
        visited[v] = 2;
        order.push(v);
        return true;
	
    }        

}
}