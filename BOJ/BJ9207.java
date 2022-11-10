package com.ssafy.algo.live20221110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9207 {
	static int T = 1, R = 5, C = 9, maxO, maxC;
	static char[][] map;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			map = new char[R][C];
			maxO = Integer.MAX_VALUE;
			maxC = Integer.MAX_VALUE;
			
			
			for(int i = 0; i < R; i++) {
				String str = sc.nextLine();
				for(int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			dfs(0, 0);
			System.out.println(maxO+" "+maxC);
			sc.nextLine();
		}
		
	}
	static void dfs(int depth, int cnt) {
		if(depth == R*C) {
			int count = 0;
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] == 'o') count++;
				}
			}
			
			if(maxO > count) {
				maxO = count;
				maxC = cnt;
			}
			
			return;
		}
		
		int r = depth / C;
		int c = depth % C;
		if(map[r][c] == 'o') {
			for (int d = 0; d < 4; d++) {
				int nr = r + dy[d];
				int nc = c + dx[d];
				if (check(d, r, c)) {
					map[r][c] = '.';
					map[nr + dy[d]][nc + dx[d]] = 'o';
					map[nr][nc] = '.';
					dfs(0, cnt + 1);
					map[nr + dy[d]][nc + dx[d]] = '.';
					map[nr][nc] = 'o';
					map[r][c] = 'o';
				}
			}
		}
		
		dfs(depth + 1, cnt);
		
	}
	
	
	private static boolean check(int d, int r, int c) {
		int nr = r + dy[d];
		int nc = c + dx[d];
		if(nr < 0 || nc < 0 || nr >= R || nc >= C) return false;
		
		if(map[nr][nc] == 'o') {
			nr += dy[d];
			nc += dx[d];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) return false;
			
			if(map[nr][nc] == '.') {
				return true;
			}
		}
		
		return false;
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
		
		String nextLine() {
			String str = null;
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
