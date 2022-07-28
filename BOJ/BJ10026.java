package com.ssafy.coding.BJ20220728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10026 {
	static int N, count = 0;
	static int[][] map, visited;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		map = new int[N][N];
		visited = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == 'R') {
					map[i][j] = 3;
				} else if(str.charAt(j) == 'B') {
					map[i][j] = 2;
				} else {
					map[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				count += dfs(i, j, map[i][j]);
			}
		}
		
		System.out.print(count+ " ");
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 3) map[i][j] = 1;
			}
		}
		
		count = 0;
		visited = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				count += dfs(i, j, map[i][j]);
			}
		}
		
		System.out.println(count);
	}
	
	static int dfs(int i, int j, int val) {
		if(i >= N || i < 0 || j >= N || j < 0) {
			return 0;
		}
		if(visited[i][j] == 1) return 0;
		if(map[i][j] != val) return 0;
		
		visited[i][j] = 1;
		dfs(i+1, j, val);
		dfs(i-1, j, val);
		dfs(i, j+1, val);
		dfs(i, j-1, val);
		
		return 1;
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
		
		String nextLine()  {
			String str = null;
			try {
				str = br.readLine();
			} catch(Exception e ) {
				e.printStackTrace();
			}
			return str;
		}
	}
	
}
