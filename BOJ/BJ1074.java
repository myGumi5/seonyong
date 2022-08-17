package com.ssafy.coding.live20220817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074 {
	static int N, r, c, cnt;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		int num = (int)Math.pow(2, N);
		
		divide(r, c, num);
		System.out.println(cnt);
	}
	static void divide(int y, int x, int size) {
		if(size == 1) {
			return;
		}
		
		int inner_size = size / 2;
		
		if(y < inner_size && x < inner_size) { 
			divide(y, x, inner_size);
		} else if(y < inner_size  && x >= inner_size) {
			cnt += (inner_size)* (inner_size) * 1;
			divide(y, x - inner_size, inner_size);
		} else if(y >= inner_size && x < inner_size) {
			cnt += (inner_size) * (inner_size) * 2;
			divide(y - inner_size, x, inner_size);
		} else if(y >= inner_size && x >= inner_size) {
			cnt += (inner_size) * (inner_size) * 3;
			divide(y - inner_size, x - inner_size, inner_size);
		}
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
