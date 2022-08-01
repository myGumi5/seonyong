package com.ssafy.BJ20220801.conding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.*;

public class BJ1914 {
 	static int N;
 	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		BigInteger n = new BigInteger("1");
		for(int i = 0; i < N; i++) {
			n = n.multiply(new BigInteger("2"));
		}
		
		System.out.println(n.subtract(new BigInteger("1")).toString());
		
		if(N <= 20)
			hanoi(N, 1, 2, 3);
		
		
		
	}
	static void hanoi(int N, int start, int by, int end) {
		if(N == 1) {
			System.out.println(start + " " + end);	
			return;
		}
		
		hanoi(N - 1, start, end, by);
		System.out.println(start + " " + end);
		hanoi(N - 1, by, start, end);
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
