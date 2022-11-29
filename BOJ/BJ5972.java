package com.ssafy.algo.live20221129;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ5972 {
	static int N, M;
	static int[] arr;
	static Map<Integer, ArrayList<Edge>> map = new HashMap<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N+1];
		Arrays.fill(arr, Integer.MAX_VALUE);

		for(int i = 0; i < M; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int c = sc.nextInt();
			
			if(map.get(n1) == null) {
				map.put(n1, new ArrayList<>());
				map.get(n1).add(new Edge(n2, c));
			} else {
				map.get(n1).add(new Edge(n2, c));
			}
			if(map.get(n2) == null) {
				map.put(n2, new ArrayList<>());
				map.get(n2).add(new Edge(n1, c));
			} else {
				map.get(n2).add(new Edge(n1, c));
			}
		}
		
		bfs();
		
		System.out.println(arr[N]);
		
	}
	static void bfs() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));
		arr[1] = 0;

		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(e.weight > arr[e.n]) continue;
			if(map.get(e.n) == null) continue;
			
			for(Edge sub : map.get(e.n)) {
				int val = arr[e.n] + sub.weight;
				
				if(arr[sub.n] > val) {
					arr[sub.n] = val;
					pq.add(new Edge(sub.n, arr[sub.n]));
				}
				
			}
		}
		
		
	}
	
	static class Edge implements Comparable<Edge>{
		int n, weight;

		public Edge(int n, int weight) {
			super();
			this.n = n;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [n=" + n + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
		
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
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
