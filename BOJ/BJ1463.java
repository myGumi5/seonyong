package com.ssafy.coding.live20220809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1463 {
	static int N;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		int [] dp = new int[1000001];
		
		dp[2] = 1;
		dp[3] = 1;
		for(int i = 4; i <= N; i++) {
			int a=Integer.MAX_VALUE;
			int b=Integer.MAX_VALUE;
			int c=Integer.MAX_VALUE;
			
			if(i % 3 == 0) {
				a = dp[i / 3] + 1;
			} else {
				a = dp[i - 1] + 1;
			}
	
			if(i % 2 == 0) {
				b = dp[i /  2] + 1;
			} else {
				b = dp[i - 1] + 1;
			}
			
			dp[i] = Math.min(a, b);
			
		}
		
		System.out.println(dp[N]);
		
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
