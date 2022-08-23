package com.ssafy.coding.live20220823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA7465 {
	static HashMap<Integer, ArrayList<Integer>> map;
	static int [] visited;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			map = new HashMap<>();
			visited = new int[N+1];
			for(int i = 0; i < M; i++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				
				if(map.get(num1) == null)
					map.put(num1, new ArrayList(Arrays.asList(num2)));
				else 
					map.get(num1).add(num2);
				if(map.get(num2) == null)
					map.put(num2, new ArrayList(Arrays.asList(num1)));
				else 
					map.get(num2).add(num1);
			}
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(visited[i] == 0) {
					bfs(i);
					cnt++;
				}
			}
			
			System.out.printf("#%d %d\n", t+1, cnt);
			
		}

	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = 1;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			if(map.get(n) == null) continue;
			for(int num : map.get(n)) {
				if(visited[num] == 1) continue;
				
				q.add(num);
				visited[num] = 1;
			}
			
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
