package com.ssafy.coding.live20221009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA2382 {
	static int T, N, M, K;
	static ArrayList<Virus> sub;
	static ArrayList<Virus>[][] list;
	static int[] dy = {-99, -1, 1, 0, 0};
	static int[] dx = {-99, 0, 0, -1, 1};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t= 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			sub = new ArrayList<>();
			list = new ArrayList[N][N];
			for (int i = 0; i < K; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int cnt = sc.nextInt();
				int dir = sc.nextInt();
				
				sub.add(new Virus(r, c, cnt, dir));
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					list[i][j] = new ArrayList<>();
				}
			}
			
//			move();
//			gather();
//			init();
//			move();
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					if(list[i][j] == null) continue;
//					else System.out.println(list[i][j]);
//				}
//			}
			
			pro(t);
		}
		
	}
	static void pro(int t) {
		int cnt = 0;
		int time = 0;
		
		while(time < M) {
			// 미생물 움직이기, 감소하기, 방향 바꾸기
			move();

			// 미생물 합치기
			gather();
			
			// sub 초기화
			init();
			
			// 미생물 총합 구하기
			cnt = getCnt();
			
			time++;
		}
		
		System.out.println("#"+t+" "+cnt);
	}
	
	private static void init() {
		sub = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(list[i][j] == null) continue;
				else for(Virus v : list[i][j]) {
					sub.add(v);
				}
			}
		}
		
		list = new ArrayList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		
	}
	private static int getCnt() {
		int cnt = 0;
		for(Virus v : sub) {
			cnt += v.cnt;
		}
		return cnt;
	}
	private static void gather() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(list[i][j].size() >= 2) {
					int len = list[i][j].size() - 1;
					int sum = 0;
					for(int z = len; z >= 1; z--) {
						if(list[i][j].get(z).cnt > list[i][j].get(z-1).cnt) {
							sum += list[i][j].get(z-1).cnt;
							list[i][j].remove(z-1);
						} else {
							sum += list[i][j].get(z).cnt;
							list[i][j].remove(z);
						}
					}
					list[i][j].get(0).cnt += sum;
				}
			}
		}
		
	}
	private static void move() {
		for(int i = sub.size() - 1; i >= 0; i--) {
			Virus v = sub.get(i);
			v.y += dy[v.dir];
			v.x += dx[v.dir];
			
			if(v.y == 0 || v.y == N - 1 || v.x == 0 || v.x == N - 1) {
				v.cnt = v.cnt / 2;
				if(v.cnt == 0) {
					sub.remove(i);
					continue;
				}
				v.dir = Direct(v.dir);
			}
		}
		
		for(Virus v : sub) {
			list[v.y][v.x].add(new Virus(v.y, v.x, v.cnt, v.dir));
		}
	}

	private static int Direct(int dir) {
		if(dir == 1) {
			 return 2;
		} else if(dir == 2) {
			return 1;
		} else if(dir == 3) {
			return 4;
		} else {
			return 3;
		}
	}

	static class Virus{
		int y, x, cnt, dir;

		public Virus(int y, int x, int cnt, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Virus [y=" + y + ", x=" + x + ", cnt=" + cnt + ", dir=" + dir + "]";
		}
		
		
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {

					st = new StringTokenizer(br.readLine());

				} catch (IOException e) {
					// TODO Auto-generated catch block
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
