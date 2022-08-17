package com.ssafy.coding.live20220817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {
	static int N, white, blue;
	static int [][] map;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
				
		white = 0;
		blue = 0;
		
		divide(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
		
	}
	static void divide(int x, int y, int size) {
		if(check(x, y, size)) {
			if(map[y][x] == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}
		
		divide(x, y, size / 2);
		divide(x, y + size / 2, size / 2);
		divide(x + size / 2, y, size / 2);
		divide(x + size / 2, y + size / 2, size / 2);
		
	}
	
	static boolean check(int x, int y, int size) {
		int num = map[y][x];
		for(int i = y; i < size + y; i++) {
			for(int j = x; j < size + x; j++) {
				if(num != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
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
