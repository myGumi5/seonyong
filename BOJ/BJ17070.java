package com.ssafy.coding.live20220826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17070 {
	static int N, cnt = 0;
	static int[][] map;
	static int [] dy = {0, 1, 1};
	static int [] dx = {1, 1, 0};
	
	
	public static void main(String[] args) {
		
		FastReader sc  = new FastReader();
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		bfs();
		
		System.out.println(cnt);
	}
	static void bfs() {
		Queue<Pipe> q = new LinkedList<>();
		q.add(new Pipe(0, 1, 0));
		
		while(!q.isEmpty()) {
			Pipe p = q.poll();			
			
			for(int i = 0; i < 3; i++) {
				int r = p.y + dy[i];
				int c = p.x + dx[i];
				
				
				if(r >= N || c >= N) {
					continue;
				}
				if(r == N - 1 && c != N-1 && i == 2) continue;
				if(r != N - 1 && c == N-1 && i == 0) continue;				
				if(Math.abs(p.dir - i) >= 2) continue;
				if(isMove(r, c, i)) continue;				
				if(r == N-1 && c == N-1) {
					cnt++;
					continue;
				}
				
				q.add(new Pipe(r, c, i));
			}
		}	
	}
	static boolean isMove(int i, int j, int dir) {
		if(dir == 0) {
			if(map[i][j] == 1) return true;
		} else if(dir == 1) {
			if(map[i][j-1] == 1 || map[i-1][j] == 1 || map[i][j] == 1) return true;
		} else {
			if(map[i][j] == 1) return true;
		}
		
		return false;
	}
	
	static class Pipe{
		int y, x, dir;

		public Pipe(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Pipe [y=" + y + ", x=" + x + ", dir=" + dir + "]";
		}
		
		
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
		
		String nextLine() {
			String str = null;
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
		
	}
}
