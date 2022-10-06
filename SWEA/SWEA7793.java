package com.ssafy.coding.live20221006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA7793 {
	static int T, R, C, ans = Integer.MAX_VALUE;
	static int[] suyeon = new int[2], god = new int[2];
	static char[][] map;
	static int[][][] visited;
	static ArrayList<int[]> list = new ArrayList<>();
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t=0; t < T; t++) {
			R = sc.nextInt();
			C = sc.nextInt();
			god = new int[2];
			suyeon = new int[2];
			ans = Integer.MAX_VALUE;
			list = new ArrayList<>();
			map = new char[R][C];
			visited = new int[2][R][C];
			
			for(int i = 0; i < R; i++) {
				String str = sc.nextLine();
				for(int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'S') {
						suyeon[0] = i;
						suyeon[1] = j;
					} else if(map[i][j] == '*') {
						int [] devil = new int[2];
						devil[0] = i;
						devil[1] = j;
						list.add(devil);
					} else if(map[i][j] == 'D') {
						god[0] = i;
						god[1] = j;
					}
				}
			}
			
			bfs();
			if(ans == Integer.MAX_VALUE) {
				System.out.println("#"+(t+1)+" GAME OVER");
			} else {
				System.out.println("#"+(t+1)+" " + (ans));
			}
		}
		
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for(int[] devil : list) {
			q.add(new Node(devil[0], devil[1], 1));
			visited[0][devil[0]][devil[1]] = 1;
		}
		while(!q.isEmpty()) {
			Node n = q.poll();
			int y = n.y;
			int x = n.x;
			
			for(int d = 0; d < 4; d++) {
				int nr = y + dy[d];
				int nc = x + dx[d];
				
				if(nr <0 || nc < 0 || nr >= R || nc >= C) continue;
				if(visited[0][nr][nc] >= 1) continue;
				if(map[nr][nc] == 'X' || map[nr][nc] == 'D') continue;
				
				visited[0][nr][nc] = n.dist+1;
				q.add(new Node(nr, nc, n.dist + 1));
			}
			
		}
//		for(int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(visited[0][i]));
//		}
//		System.out.println();
		
		Queue<Node> qs = new LinkedList<>();
		qs.add(new Node(suyeon[0], suyeon[1], 1));
		visited[1][suyeon[0]][suyeon[1]] = 1;
		
		while(!qs.isEmpty()) {
			Node n = qs.poll();
			int y = n.y;
			int x = n.x;
			
			for(int d = 0; d < 4; d++) {
				int nr = y + dy[d];
				int nc = x + dx[d];
				
				if(nr <0 || nc < 0 || nr >= R || nc >= C) continue;
				if(visited[1][nr][nc] >= 1) continue;
				if(map[nr][nc] == 'X' || map[nr][nc] == '*') continue;
				if(map[nr][nc] == 'D') {
					ans = Math.min(ans, n.dist);
					continue;
				}
				if(visited[0][nr][nc] != 0 && visited[0][nr][nc] <= n.dist+1) continue;
				
				visited[1][nr][nc] = n.dist+1;
				qs.add(new Node(nr, nc, n.dist + 1));
			}
		}
//		for(int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(visited[1][i]));
//		}
		
	}
	
	static class Node{
		int y, x, dist;

		public Node(int y, int x, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", dist=" + dist + "]";
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
