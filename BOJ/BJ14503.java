package com.ssafy.coding.live20220812;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14503 {
	static int N, M, cnt = 1, search_dir = 0;
	static int[][] map;
	static Robot r;
	
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, -1, 0, 1};
	static int [] back_dx = {0, -1, 0, 1};
	static int [] back_dy = {1, 0, -1, 0};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		r = new Robot(sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		map[r.r][r.c] = 2;
		
		while(move()) {
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
		}
		
		System.out.println(cnt);
	}
	static boolean move() {
		int ry = r.r + dy[r.dir];
		int cx = r.c + dx[r.dir];
		
		if(search_dir == 4) {
			int rt = r.r + back_dy[r.dir];
			int ct = r.c + back_dx[r.dir];
			
			if(map[rt][ct] == 1) {
				return false;
			} else {
				r.r = rt;
				r.c = ct;
				search_dir = 0;
				return true;
			}
			
		}
		
		if(map[ry][cx] == 0) {
			r.r = ry;
			r.c = cx;
			if(r.dir == 0) {
				r.dir = 3;
			} else if(r.dir == 1) {
				r.dir = 0;
			} else if(r.dir == 2) {
				r.dir = 1;
			} else if(r.dir == 3) {
				r.dir = 2;
			}
			map[ry][cx] = 2;
			cnt++;
			search_dir = 0;
			return true;
		}
		
		if(map[ry][cx] != 0) {
			if(r.dir == 0) {
				r.dir = 3;
			} else if(r.dir == 1) {
				r.dir = 0;
			} else if(r.dir == 2) {
				r.dir = 1;
			} else if(r.dir == 3) {
				r.dir = 2;
			}
			search_dir++;
			return true;
		}
		
		return false;
	}
	
	static class Robot{
		int r;
		int c;
		int dir;
		
		public Robot(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Robot [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
		
	}
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
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
