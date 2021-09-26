package com.practice;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	
	private int V;
	
	private LinkedList[] adj;
	
	private boolean[] visited;
	
	private void addEdge(int u, int w) {
		adj[u].add(w);
	}
	BFS(int v){
		V = v;
		visited = new boolean[V];
		adj = new LinkedList[V];
		for(int i=0;i<V;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	private void triggerBFS(int v) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[v] = true;
		queue.add(v);
		int s;
		
		while(queue.size()!=0) {
			
			s = queue.poll();
			
			System.out.println("vertex is "+s);
			
			Iterator<Integer> i = adj[s].iterator();
			
			while(i.hasNext()) {
				int j = i.next();
				
				if(!visited[j]) {
					visited[j] = true;
					queue.add(j);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
		BFS g = new BFS(4);
		
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
		
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.triggerBFS(2);
	}

}
