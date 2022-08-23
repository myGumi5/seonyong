package com.ssafy.coding.live20220823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA2819 {
	static int T, cnt;
	static int [][] map;
	static HashMap<String, Integer> hash;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			cnt = 0;
			hash = new HashMap<>();
			map = new int[4][4];
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					dfs(i, j, "");
				}
			}
			
			//System.out.println(hash);
			System.out.printf("#%d %d\n",t+1, hash.size());
			
		}

	}
	static void dfs(int i, int j, String str) {
		if(i < 0 || i >= 4 || j < 0 || j >= 4) return;
		if(str.length() == 7) {
			hash.put(str, 1);
			return;
		}
		
		
		dfs(i + 1, j, str + map[i][j]);
		dfs(i - 1, j, str + map[i][j]);
		dfs(i , j+1, str + map[i][j]);
		dfs(i , j-1, str + map[i][j]);
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			// TODO Auto-generated constructor stub
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
	}
	
}
