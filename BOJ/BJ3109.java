package com.ssafy.coding.live20220819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3109 {
	static int N, M, cnt = 0;
	static char[][] map, copy;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][M];
		copy = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				copy[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(dfs(i, 0)) cnt++;
		}
		
		System.out.println(cnt);
	}
	static boolean dfs(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= M) return false;
		if(map[r][c] != '.') return false;
		if(c == M-1) {
			return true;
		}
		
		map[r][c] = 'o';
		
		
		if(dfs(r - 1, c + 1)) return true;
		if(dfs(r, c + 1)) return true;
		if(dfs(r + 1, c + 1))return true;
		
		return false;
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
		
		String nextLine() {
			String str = null;
			try {
				str = br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return str;
		}
	}
	

}

/*
5 5
.xx..
..x..
....X
...x.
...x.
 
 */
