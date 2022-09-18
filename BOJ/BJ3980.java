package com.ssafy.coding.live20220918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ3980 {
	static int T, ans;
	static int[][] map;
	static int[] visited;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			ans = Integer.MIN_VALUE;
			visited = new int[11+1];
			
			map = new int[11][11];
			for(int i = 0; i < 11; i++) {
				for(int j = 0; j < 11; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			permutation(new int[11+1], 1);
			System.out.println(ans);
		}
		
		
	}
	static void permutation(int[] per, int depth) {
		if(depth >= 11 + 1) {
			//System.out.println(Arrays.toString(Arrays.copyOfRange(per, 1, depth)));
			
			int sum = 0;
			int number = 0;
			for(int i = 1; i <= depth-1; i++) {
				int position = per[i] - 1;
				sum += map[number++][position];
			}
			
			ans = Math.max(ans, sum);
			
			return;
		}
		
		for(int i = 1; i <= 11; i++) {
			if(visited[i] == 1) continue;
			if(map[depth-1][i-1] == 0) continue;
			per[depth] = i;
			
			visited[i] = 1;
			permutation(per, depth+1);
			visited[i] = 0;
		}
	}
	
	static class FastReader {
		BufferedReader br = null;
		StringTokenizer st = null;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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
			}catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
