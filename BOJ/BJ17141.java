package com.ssafy.coding.live20221024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17141 {
	static int N, M, ans;
	static boolean[] check;
	static int[][] map, sub, visited;
	
	static ArrayList<int[]> list;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = Integer.MAX_VALUE;
		list = new ArrayList<>();
		map = new int[N][N];
		sub = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] != 2) sub[i][j] = map[i][j];
				if(map[i][j] == 2) {
					list.add(new int[] {i, j});
				}
			}
		}
		
		check = new boolean[list.size()];
		dfs(0, 0);
		
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	static void dfs(int depth, int cnt) {
		if(cnt >= M) {
			visited = new int[N][N];
			int max = bfs();
			
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
//			System.out.println();
			
			if(checkArr()) {
				ans = Math.min(ans, max);
			}
//			System.out.println(Arrays.toString(check));
			return;
		}
		if(depth >= list.size()) {
			return;
		}
		
		int r = list.get(depth)[0];
		int c = list.get(depth)[1];
		sub[r][c] = 2;
		check[depth] = true;
		dfs(depth + 1, cnt + 1);
		sub[r][c] = 0;
		check[depth] = false;
		dfs(depth + 1, cnt);
	}
	
	private static boolean checkArr() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0 && sub[i][j] != 1) return false;
			}
		}
		
		return true;
	}
	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		for(int i = 0; i < list.size(); i++) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			if(check[i]) {
				q.add(new Node(r, c, 0));
				visited[r][c] = 1;
			}
		}
		
		int max = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			int r = n.y;
			int c = n.x;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dy[i];
				int nc = c + dx[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(visited[nr][nc] >= 1) continue;
				if(sub[nr][nc] == 1) {
					visited[nr][nc] = 9;
					continue;
				}
				
				visited[nr][nc] = n.dist + 1;
				q.add(new Node(nr, nc, n.dist + 1));
				max = Math.max(n.dist+1, max);
			}
		}
		
		return max;
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
