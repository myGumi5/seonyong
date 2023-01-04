package com.ssafy.algo.live20230104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1085 {
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int x = sc.nextInt(), 
			y = sc.nextInt(), 
			w = sc.nextInt(), 
			h = sc.nextInt();
		
		int a = w - x;
		int b = h - y;
		
		int resX = Math.min(x, a);
		int resY = Math.min(y, b);
		
		System.out.println(Math.min(resX, resY));
		
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
