package com.ssafy.algo.live20221102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ20208_2 {
	static int N, M, H, startR, startC, cnt;
	static int[][] map;
	
	static int coorR, coorC;
	static boolean[] visited;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		map = new int[N][N];
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) list.add(new int[] {i, j});
				if(map[i][j] == 1) {
					startR = i;
					startC = j;
					coorR = i;
					coorC = j;
				}
			}
		}
		
		visited = new boolean[list.size()];
		dfs(0, 0, M, startR, startC);
		
		System.out.println(cnt);
	}
	static void dfs(int depth, int count, int h, int R, int C) {
		if(depth == list.size()) {
			return;
		}
		
		if(canBack(R, C, h)) {
			cnt = Math.max(cnt, count);
		}
		//		System.out.println(Arrays.toString(visited));
		
		if(!visited[depth]) {
			visited[depth] = true;
			if(check(depth, h)) {
				dfs(0, count+1, getH(depth, h), startR, startC);
				init(R, C);
			}
			visited[depth] = false;
		}
		dfs(depth + 1, count, h, R, C);
	}
	
	private static boolean canBack(int r, int c, int h) {
		if(Math.abs(coorR - r) + Math.abs(coorC - c) > h)
				return false;
		
		return true;
	}
	private static int getH(int depth, int h2) {
		int R = list.get(depth)[0];
		int C = list.get(depth)[1];
		
		h2 = (h2 - (Math.abs(startR - R) + Math.abs(startC - C))) + H;
		
		startR = R;
		startC = C;
		
		return h2;
	}
	private static void init(int R, int C) {
		startR = R;
		startC = C;
	}
	private static boolean check(int depth, int h) {
		int R = list.get(depth)[0];
		int C = list.get(depth)[1];
		
		if(Math.abs(startR - R) + Math.abs(startC - C) > h) {
			return false;
		}
		
		return true;
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
