package com.ssafy.algo.live20220930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3282 {
	static int T, N, W;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			W = sc.nextInt();
			
			map = new int[N+1][2+1];
			dp = new int[N+1][W+1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= 2; j++)
					map[i][j] = sc.nextInt();
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= W; j++) {
					if(j < map[i][1]) dp[i][j] = dp[i-1][j];
					else {
						dp[i][j] = Math.max(dp[i-1][j], map[i][2] + dp[i-1][j - map[i][1]]);
					}
				}
			}
			
			System.out.printf("#%d %d\n", t+1, dp[N][W]);
			
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
