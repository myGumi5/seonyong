package com.ssafy.coding.live20220823;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3124 {
	static int V, E;
	static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
		
	}
	
	static void makeSet() {
		parents = new int[V+1];
		for(int i = 0; i <= V; i++) {
			parents[i] = i;
		}
		
	}
	
	static int findSet(int n) {
		if(parents[n] == n) return n;
		else return parents[n] = findSet(parents[n]);
	}
	
	static boolean union(int from, int to) {
		int fRoot = findSet(from);
		int tRoot = findSet(to);
		
		if(fRoot == tRoot) return false;
		
		parents[tRoot] = fRoot;
		return true;
	}
	
	public static void main(String[] args) {
		FastReader sc  = new FastReader();
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			makeSet();
			
			Edge [] edgeList = new Edge[E];
			for(int i = 0; i < E; i++) {
				edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			
			Arrays.sort(edgeList);
			
			long result = 0;
			for(Edge e : edgeList) {
				if(union(e.from, e.to)) {
					result += e.weight;
				}
			}
			
			System.out.printf("#%d %d\n", t+1, result);
		}
		
		
		
	}
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			// TODO Auto-generated constructor stub
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
	}
}
