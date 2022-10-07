package com.ssafy.algo.live20221007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17142 {
	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] map, visited, sub;
	static ArrayList<int[]> list = new ArrayList<>();
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		sub = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				list.add(new int[]{i, j});
			}
		}
		
		dfs(0, 0);
		if(ans == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(ans);
		
	}
	static void dfs(int depth, int cnt) {
		// 백트레킹 조건
		//if((N * N - depth) < (M - cnt)) return;
				
		if(cnt == M) {
			visited = new int[N][N];
			int val = bfs() - 1;
			
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
//			System.out.println();
//			
			if(check()) {
				ans = Math.min(ans, val);
			}
			
			return;
		}
		
		if(depth == N * N) return;

		
		int r = list.get(depth)[0];
		int c = list.get(depth)[1];
		// 선택
		if(map[r][c] == 2) {
			map[r][c] = 4;
			dfs(depth+1, cnt+1);
			map[r][c] = 2;
		}
		// 비선택
		dfs(depth + 1, cnt);
		
	}
	
	
	private static boolean check() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0 && map[i][j] == 0) return false;
			}
		}
		
		return true;
	}
	private static int bfs() {
		int max = Integer.MIN_VALUE;
		
		Queue<Node> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 4) {
					q.add(new Node(i, j, 1));
					visited[i][j] = 1;
				}
			}
		}
		max = Math.max(max, 1);
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int y = n.y;
			int x = n.x;
			
				
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if(visited[ny][nx] == 1) continue;
				if(map[ny][nx] == 1) continue;
				if(map[ny][nx] == 2) {
					q.add(new Node(ny, nx, n.dist+1));
					visited[ny][nx] = 1;
					continue;
				}
				
				q.add(new Node(ny, nx, n.dist + 1));
				visited[ny][nx] = 1;
				max = Math.max(max, n.dist+1);
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
				} catch(Exception e) {
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
