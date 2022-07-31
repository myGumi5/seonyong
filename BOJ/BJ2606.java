package com.ssafy.cding.BJ20220731;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2606 {
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	static int V, E, cnt = 0;
	static boolean[] visited;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		V = sc.nextInt();
		E = sc.nextInt();
		
		visited = new boolean[V+1];
		
		for(int i = 0; i < E; i ++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			if(map.get(node1) == null) {
				map.put(node1, new ArrayList(Arrays.asList(node2)));
			} else {
				map.get(node1).add(node2);
			}
			if(map.get(node2) == null) {
				map.put(node2, new ArrayList(Arrays.asList(node1)));
			} else {
				map.get(node2).add(node1);
			}
			
		}
		
		dfs();

		
		System.out.println(cnt);
		
	}
	
	static void dfs() {
		int start = 1;
		LinkedList<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			if(map.get(node) == null) continue;
			for(int i : map.get(node)) {
				if(visited[i]) continue;
				
				visited[i] = true;
				q.add(0, i);
				cnt++;
			}
			
		}
	
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while(st ==  null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch (Exception e) {
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
