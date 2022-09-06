package com.ssafy.coding.live20220907;

import java.io.*;
import java.util.*;

public class BJ7579 {
	static int N, M, min;
	static int[] memo, cost;
	static int[][] dp;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		
		memo = new int[N + 1];
		cost = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			memo[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt();
		}

		dp = new int[N + 1][10001];
		// 메모리가 나올 수 있는 최대 값 100 * 100 = 10,000
		
		min = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= 10000; j++) {
				if(j < cost[i]) {
					dp[i][j] = dp[i-1][j];
					continue;
					// 메모리의 값보다 idx가 작으면 이전 값을 그대로 가져온다.
				}
				
				dp[i][j] = Math.max(dp[i-1][j], memo[i]+dp[i-1][j - cost[i]]);
				if(dp[i][j] >= M) min = Math.min(min, j);
			}
		}
		
		System.out.println(min);
		
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
