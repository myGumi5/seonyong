package com.ssafy.coding.live20220818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1987 {
	static int R, C, max = Integer.MIN_VALUE;
	static char [][] map;
	static int [][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		visited = new int[R][C];
		for(int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		dfs(0, 0, 1, "");
		
		System.out.println(max);
		
	}
	static void dfs(int i , int j, int depth, String str) {
		if(i < 0 || i >= R || j < 0 || j >= C) return;
		for(int c = 0; c < str.length(); c++) {
			if(str.charAt(c) == map[i][j]) {
				max = Math.max(max, depth-1);
				return;
			}
		}
		
		
		dfs(i+1, j, depth+1, str+map[i][j]);
		dfs(i, j+1, depth+1, str+map[i][j]);
		dfs(i-1, j, depth+1, str+map[i][j]);
		dfs(i, j-1, depth+1, str+map[i][j]);
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
