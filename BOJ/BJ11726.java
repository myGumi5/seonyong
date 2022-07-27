package com.ssafy.coding.BJ11726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11726 {
	static int N;
	static long[] arr;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		arr = new long[N+10];
		arr[0] = 1;
		arr[1] = 2;
		
		
		for(int i = 2; i <= N; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 10007;
		}
		
		System.out.println(arr[N-1]);
		
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
