package com.ssafy.BJ20220801.conding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20309 {
	static int N;
	static int [] arr;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num % 2 == 1) {
				if(i % 2 != 0) {
					System.out.println("NO");
					return;
				}
			} else {
				if(i % 2 != 1) {
					System.out.println("NO");
					return;
				}
			}
		}
		
		System.out.println("YES");
		
	}
	
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while(st ==  null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch (Exception e) {
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
