package com.ssafy.coding.live20221004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA5656 {
	static int T, N, W, H, ans;
	static boolean flag;
	static int[][] map;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			map = new int[H][W];
			for(int i = 0; i <H; i++) {
				for(int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			flag = false;
			ans = Integer.MAX_VALUE;
			dfs(0, map);
			
			System.out.println("#"+(t+1)+" "+ans);
		}	
	}
	static void dfs(int cnt, int[][] copy) {
		if(cnt == N) {
			ans = Math.min(ans, count(copy));
			if(ans == 0) flag = true;
			return;
		}
		
		if(flag) return;
		
		int[][] sub = copy(copy);
		for(int i = 0; i < W; i++) {
			// 벽돌 깨부수기
			bfs(i, sub);
//			for(int z = 0; z < H; z++) {
//				System.out.println(Arrays.toString(sub[z]));
//			}
//			System.out.println();
			// 정리하기
			clear(sub);
//			for(int z = 0; z < H; z++) {
//				System.out.println(Arrays.toString(sub[z]));
//			}
			// 다음 시작
			dfs(cnt+1, sub);
			sub = copy(copy);
		}
		
		//dfs(cnt, copy);
		
	}
	
	/*
1
3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1

	*/
	

	static void bfs(int c, int[][] sub) {
		int r = getR(c, sub);
		if(r == H) return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c, sub[r][c]));
		sub[r][c] = 0;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int y = n.y;
			int x = n.x;
			
			for(int d = 0; d < 4; d++) {
				int ny = y;
				int nx = x;
				for(int l = 0; l < n.life - 1; l++) {
					ny += dy[d];
					nx += dx[d];
					
					if(ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
					if(sub[ny][nx] == 0) continue;
					
					if(sub[ny][nx] > 1) {
						q.add(new Node(ny, nx, sub[ny][nx]));
					}
					sub[ny][nx] = 0;
				}
				
			}
			
			
		}
		
	}
	private static int count(int[][] copy) {
		int count = 0;
		
		for(int i = 0; i <H; i++) {
			for(int j = 0; j < W; j++) {
				if(copy[i][j] != 0) count++;
			}
		}
		return count;
	}
	private static void clear(int[][] sub) {
		Queue<Integer> q = null;
		for(int j = 0; j < W; j++) {
			q = new LinkedList<Integer>();
			for(int i = H-1; i >= 0; i--) {
				if(sub[i][j] != 0) q.add(sub[i][j]);
			}
			
			int i = H-1;
			while(i >= 0) {
				if(!q.isEmpty()) sub[i][j] = q.poll();
				else sub[i][j] = 0;
				i--;
			}
			
		}
		
	}
	private static int getR(int c, int[][] sub) {
		int r = 0;
		
		while(r < H && sub[r][c] == 0) {
			r++;
		}
		
		return r;
	}
	private static int[][] copy(int[][] copy) {
		int[][] sub = new int[H][W];
		
		for(int i = 0; i <H; i++) {
			for(int j = 0; j < W; j++) {
				sub[i][j] = copy[i][j];
			}
		}
		return sub;
	}
	static class Node{
		int y, x, life;

		public Node(int y, int x, int life) {
			super();
			this.y = y;
			this.x = x;
			this.life = life;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", life=" + life + "]";
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		String nextLine() {
			String str = null;
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return str;
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
