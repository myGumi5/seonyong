package com.ssafy.coding.live20221027;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ18428 {
	static int N;
	static boolean flag;
	static ArrayList<int[]> list;
	static char[][] map;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		list = new ArrayList<>();
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextChar();
				if(map[i][j] == 'T') list.add(new int[] {i, j});
			}
		}
		
//		System.out.println(Arrays.toString(map[0]));
		dfs(0, 0);
		
		if(flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	static void dfs(int depth, int cnt) {
		if(flag) return;
		if(cnt == 3) {
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			
			flag = bfs();
			
			return;
		}
		if(depth >= (N * N)) return;
		
		
		int r = depth / N;
		int c = depth % N;
		
		if(map[r][c] == 'X') {
			map[r][c] = 'O';
			dfs(depth+1, cnt+1);
			map[r][c] = 'X';
		}	
		dfs(depth+1, cnt);
		
	}
	
	private static boolean bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int[] arr : list) {
			q.add(arr[0]);
			q.add(arr[1]);		
		}
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = r;
				int nc = c;
				while(true) {
					nr += dy[d];
					nc += dx[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
					if(map[nr][nc] == 'O') break;
					
					if(map[nr][nc] == 'S') return false;
				}
			}
		}
		
		return true;
	}

	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			br = new BufferedReader(new java.io.InputStreamReader(System.in));
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
			} catch(Exception e) {
				e.printStackTrace();
			}
			return str;
		}
		
		char nextChar() {
			return next().charAt(0);
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
