package com.ssafy.coding.BJ1024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1024 {

	public static void main(String[] args) {
		long N, L;
		
		/*
		 18 = N + N+1
		 18 = 2N+1
		 17 = 2N;
		 
		 18 = N + N+1 + N+2
		 18 = 3N + 3
		 15 = 3N
		 */
		
		FastReader sc = new FastReader();
		N = sc.nextInt();
		L = sc.nextInt();
		
		long sum = 0;
		while(L <= 100) {
			sum = 0;
			for(int i = 0; i < L; i++) {
				sum += i;
			}
			
			long result = (N - sum) % L;
			if(N < sum) break;
			if(result == 0) {
				break;
			} else {
				L++;
			}
		}
		
		if(L > 100 || N < sum) {
			System.out.println(-1);
		}else {
			long a = ((N - sum) / L) + L;
			for(long i = (N - sum) / L; i < a; i++) {
				System.out.print(i+" ");
			}
		}
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
