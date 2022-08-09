package com.ssafy.coding.live20220809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501 {
	static int N;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		int max = 0;

		int dp[] = new int [N+2];
		for(int i = 1; i < N+1; i++) {
			int T = sc.nextInt();
			int P = sc.nextInt();
			
			dp[i] = Math.max(dp[i], dp[i-1]);
			if(i+T > N+1) continue;
			dp[i+T] = Math.max(dp[i] + P, dp[i + T]);
			max = Math.max(dp[i+T], max);
			
		}
		

		
		System.out.println(max);
	}
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null ||!st.hasMoreElements()) {
				try{
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {
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
