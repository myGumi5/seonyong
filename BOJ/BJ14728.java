package com.ssafy.coding.live20220905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14728 {
	static int N, max;
	static int[] times, scores;
	static int[][] dp;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		max = sc.nextInt();
		
		times = new int[N+1];
		scores = new int[N+1];
		dp = new int[N+1][max+1];
		for(int i = 1; i <= N; i++) {
			times[i] = sc.nextInt();
			scores[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= max; j++) {
				if(times[i] > j) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = Math.max(dp[i - 1][j], scores[i] + dp[i-1][j - times[i]]);
			}
		}
		
		//System.out.println(Arrays.toString(dp[N]));
		System.out.println(dp[N][max]);
		
	}
	static class FastReader {
		BufferedReader br = null;
		StringTokenizer st = null;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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
