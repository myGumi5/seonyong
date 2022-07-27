package com.ssafy.coding.BJ12865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ12865 {
	static int N, K;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		int [][] arr = new int[N+1][K+1];
		int [] w = new int[N+1];
		int [] v = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(j >= w[i]) arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-w[i]] + v[i]);
				else arr[i][j] = arr[i-1][j];
					
			}
		}
		
		System.out.println(arr[N][K]);
		

	}

	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
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
