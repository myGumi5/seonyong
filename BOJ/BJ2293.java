package com.ssafy.coding.live20220810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2293 {
	static int N, K;
	static int[] dp;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		K = sc.nextInt();
		
		dp = new int [K+1];
		
		int num = sc.nextInt();
		for(int i = 1; i <= K; i++) {
			if(i < num) dp[i] = 0;
			else if(i == num) dp[i] = 1;
			else dp[i] = dp[i - num];
		}
		
		
		for(int i = 1; i < N; i++) {
			int n = sc.nextInt();
			for(int j = 1; j <= K; j++) {
				if(j < n) continue;
				if(j == n) {
					dp[j] = dp[j] + 1;
					continue;
				}
				dp[j] = dp[j] + dp[j - n];
			}
		}
		
		System.out.println(dp[K]);
		
	}
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		FastReader(){
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
