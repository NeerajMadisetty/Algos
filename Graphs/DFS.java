package com.practice;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	
	private int noOfVertices;
	private LinkedList[] adj;
	
	Graph(int v){
		noOfVertices= v;
		adj = new LinkedList[v];
		for(int i=0;i<adj.length;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
	
	void DFS(int v) {
		boolean[] visited = new boolean[noOfVertices];
		DFSUtil(v,visited);
	}
	
	void DFSUtil(int v,boolean[] visited) {
		visited[v] = true;
		System.out.println(v+" ");
		Iterator<Integer> it = adj[v].listIterator();
		while(it.hasNext()) {
			int w = it.next();
			if(!visited[w]) {
				DFSUtil(w,visited);
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+ "(starting from vertex 2)");
 
        g.DFS(2);
	}

}
