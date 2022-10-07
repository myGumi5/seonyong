package com.ssafy.coding.live20221007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15661 {
	static int N, ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		visited = new boolean[N+1];
		map = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(1);
		System.out.println(ans);
		
	}
	static void dfs(int depth) {
		if(depth == N + 1) {
			ArrayList<Integer> link = new ArrayList<>();
			ArrayList<Integer> start = new ArrayList<>();
			
			for(int i = 1; i <= N; i++) {
				if(visited[i]) link.add(i);
				else start.add(i);
			}
			
			int linkS = getScore(link);
			int startS = getScore(start);
			
			ans = Math.min(ans, Math.abs(linkS - startS));
			
			return;
		}
		
		visited[depth] = true;
		dfs(depth + 1);
		visited[depth] = false;
		dfs(depth+1);
	}

	private static int getScore(ArrayList<Integer> list) {
		int sum = 0;
		for(int i : list) {
			for(int j : list) {
				sum += map[i][j];
			}
		}
		
		return sum;
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
