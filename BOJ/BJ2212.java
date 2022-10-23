package com.ssafy.coding.live20221023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2212 {
	static int N, K;
	static int[] map, sub;
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N];
		for(int i = 0; i < N; i++) {
			map[i] = sc.nextInt();
		}
		
		Arrays.sort(map);
		sub = new int[N-1];
		for(int i = 0; i < N - 1; i++) {
			sub[i] = map[i+1] - map[i];  
		}
		
		int sum = 0;
		Arrays.sort(sub);
		for(int i = 0; i < N - K; i++) {
			sum += sub[i];
		}
		
		System.out.println(sum);
		
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
