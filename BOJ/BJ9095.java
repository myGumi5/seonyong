package com.ssafy.algo.live20220930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9095 {
	static int T, N;
	static int [] dp;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			dp = new int[N+1];
			System.out.println(dfs(N));
		}
		
	}
	static int dfs(int num) {
		if(num == 0) return 1;
		if(num < 0) return 0;
		
		int cnt = 0;
		
		if(dp[num] != 0) return dp[num];
		
		// 1선택 시 
		cnt += dfs(num - 1);
		
		// 2선택 시
		cnt += dfs(num - 2);
		
		// 3선택 시
		cnt += dfs(num - 3);
		
		dp[num] = cnt;
		
		return cnt;
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
