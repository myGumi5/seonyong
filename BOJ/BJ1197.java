package com.ssafy.coding.BJ20220728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1197 {
	static ArrayList<Edge> edges = new ArrayList<>();
	static HashMap<Integer, Integer> parant = new HashMap<>();
	static HashMap<Integer, Integer> rank = new HashMap<>();
	static int V, E;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		edges = new ArrayList<>();
		parant = new HashMap<>();
		rank = new HashMap<>();
		
		for(int i = 1; i <= E; i++) {
			int ver1 = sc.nextInt();
			int ver2 = sc.nextInt();
			int edge = sc.nextInt();
	
			edges.add(new Edge(ver1, ver2, edge));
		}
		
		kruscalFunction();
		
	}
	static void init() {
		for(int i = 0; i <= E; i++) {
			parant.put(i, i);
			rank.put(i, 0);
		}
		
	}
	
	static int find(int node) {
		if(parant.get(node) == null) return node;
		
		if(node != parant.get(node)) {
			parant.put(node, find(parant.get(node)));
		}
		
		return parant.get(node);
	}
	
	static void union(int node1, int node2) {
		int n1 = find(node1);
		int n2 = find(node2);
		
		if(rank.get(n1) == null || rank.get(n2) == null) return;
		if(parant.get(n1) == null || parant.get(n2) == null) return;
		
		
		// 두 노드 부모의 랭크가 같을 때 
		if(rank.get(n1) == rank.get(n2)) {
			rank.put(n2, rank.get(n2) + 1);
			parant.put(n2, n1);
		} else {
			// 두 노드 부모의 랭크가 다를 때,
			// node1 부모의 랭크가 클 때,
			if(rank.get(n1) > rank.get(n2)) {
				parant.put(n2, n1);
			}
			
			// node2 부모의 랭크가 클 때,
			if(rank.get(n1) < rank.get(n2)) {
				parant.put(n1, n2);
			}
		}
		
	}
	
	static void kruscalFunction() {
		ArrayList<Integer> mst = new ArrayList<>();
		
		init();
		// 해쉬맵 초기화
		
		Collections.sort(edges);
		// 최소 간선부터 시작
		
		
		for(int i = 0; i < edges.size(); i++) {
			int node1 = edges.get(i).node1;
			int node2 = edges.get(i).node2;
			
			// 서로의 부모가 다르면 최소값을 추가한다.
			if(find(node1) != find(node2)) {
				union(node1, node2);
				mst.add(edges.get(i).edge);
			}
			
		}
		
		int sum = 0;
		for(int i = 0; i < mst.size(); i++) {
			sum += mst.get(i);
		}
		
		//System.out.println(parant);
		System.out.println(sum);
	}
	
	
	static class Edge implements Comparable<Edge>{
		int node1;
		int node2;
		int edge;
		
		Edge(int node1, int node2, int edge){
			this.node1 = node1;
			this.node2 = node2;
			this.edge = edge;
		}

		@Override
		public String toString() {
			return "Edge [node1=" + node1 + ", node2=" + node2 + ", edge=" + edge + "]";
		}
		
		@Override
		public int compareTo(Edge e1) {
			return this.edge - e1.edge;
		}
		
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		char nextChar() {
			return next().charAt(0);
		}
	}
}
