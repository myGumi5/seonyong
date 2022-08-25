package com.ssafy.coding.live20220825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1753 {
	static class Data implements Comparable<Data>{
		int num, weight;

		public Data(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}

		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader sc = new FastReader();
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt();
		
		HashMap<Integer, ArrayList<Data>> map = new HashMap<>();
		//int [][] adjMatrix = new int[V+1][V+1];
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			
			if(map.get(from) == null) {
				map.put(from, new ArrayList(Arrays.asList(new Data(to, weight))));
			} else {
				map.get(from).add(new Data(to, weight));
			}
		}

		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Arrays.fill(distance,Integer.MAX_VALUE);
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.add(new Data(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Data n = pq.poll();
			
			if(visited[n.num]) continue;
			visited[n.num] = true;
			
			if(map.get(n.num) == null) continue;
			for(Data d : map.get(n.num)) {
				if(distance[d.num] > distance[n.num] + d.weight) {
					distance[d.num] = distance[n.num] + d.weight;
					pq.add(new Data(d.num, distance[d.num]));
				}
			}
		}

		for(int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}

	}
	static class FastReader {
		BufferedReader br = null;
		StringTokenizer st = null;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			// TODO Auto-generated constructor stub
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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

/*
3 3
3
1 2 1
2 3 1
2 1 2

*/