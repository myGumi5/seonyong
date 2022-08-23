package com.ssafy.coding.live20220823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3289 {
	static int parents[];
	static Edge[] edgeList;
	static int V, E;
	
	static class Edge{
		int num, from, to;
		
		public Edge(int num, int from, int to) {
			this.num = num;
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + "]";
		}
		
		
	}
	
	static void make() {
		parents = new int[V+1];
		for(int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;

	}
	
	public static void main(String[] args) {
		FastRedaer sc = new FastRedaer();
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			V = sc.nextInt();
			E = sc.nextInt();

			edgeList = new Edge[E];
			for (int i = 0; i < E; i++) {
				edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}

			System.out.printf("#%d ", t + 1);
			
			make(); // init
			
			for(int i = 0; i < E; i++) {
				if(edgeList[i].num == 0) union(edgeList[i].from, edgeList[i].to);
				else {
					if(find(edgeList[i].from) == find(edgeList[i].to)) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
		}

	}
	static class FastRedaer{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastRedaer() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
