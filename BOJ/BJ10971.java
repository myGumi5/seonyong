package com.ssafy.coding.live20221009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10971 {
	static int N, ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		visited[1] = true;
		dfs(1, 0, 0);
		System.out.println(ans);
	}
	
	static void dfs(int num, int val, int cnt) {
		if(val >= ans) return;
		
		if(cnt == N - 1) {
			if(map[num][1] == 0) return;
			
			ans = Math.min(ans, val + map[num][1]);
			
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(map[num][i] == 0 || visited[i] == true) continue;
			visited[i] = true;
			dfs(i, val + map[num][i], cnt+1);
			visited[i] = false;
		}
		
	}
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {

					st = new StringTokenizer(br.readLine());

				} catch (IOException e) {
					// TODO Auto-generated catch block
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
