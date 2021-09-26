package disjoint_sets;

import java.io.*;
import java.util.*;

public class DisjointUnionSets {
	int[] rank, parent;
	int n;

	public DisjointUnionSets(int n)
	{
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}

	void makeSet()
	{
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	int find(int x)
	{
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	void union(int x, int y)
	{
		int xRoot = find(x), yRoot = find(y);

		if (xRoot == yRoot)
			return;

		if (rank[xRoot] < rank[yRoot])   parent[xRoot] = yRoot;

		else if (rank[yRoot] < rank[xRoot])

			parent[yRoot] = xRoot;

		else // if ranks are the same
		{
			parent[yRoot] = xRoot;
			rank[xRoot] = rank[xRoot] + 1;
		}
	}

	public static void main(String[] args)
	{
	
		int n = 5;
		DisjointUnionSets dus =
				new DisjointUnionSets(n);

		// 0 is a friend of 2
		dus.union(0, 2);

		// 4 is a friend of 2
		dus.union(4, 2);

		// 3 is a friend of 1
		dus.union(3, 1);

		// Check if 4 is a friend of 0
		if (dus.find(4) == dus.find(0))
			System.out.println("Yes");
		else
			System.out.println("No");

		// Check if 1 is a friend of 0
		if (dus.find(1) == dus.find(0))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

