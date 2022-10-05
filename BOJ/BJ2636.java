package com.ssafy.coding.live20221005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2636 {
	static int R, C, ans;
	static int[][] map, visited;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new int[R+2][C+2];
		
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		while(true) {
			visited = new int[R+2][C+2];
			int[][] sub = bfs();
			cnt++;
			if(check()) {
				ans = count(sub);
				break;
			}
			
		}
		
		System.out.println(cnt);
		System.out.println(ans);
		
		
		
	}
	private static int count(int[][] sub) {
		int cnt = 0;
		
		for(int i = 0; i <= R+1; i++) {
			for(int j = 0; j <= C+1; j++) {
				if(sub[i][j] == 1) cnt++;
			}
		}
		
		return cnt;
	}
	private static boolean check() {
		for(int i = 0; i <= R+1; i++) {
			for(int j = 0; j <= C+1; j++) {
				if(map[i][j] != 0) return false;
			}
		}
		return true;
	}
	static class Node{
		int x, y, cost;

		public Node(int y, int x, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cost=" + cost + "]";
		}
	}
	
	static int[][] bfs() {
		int[][] sub = new int[R+2][C+2];
		for(int i = 0; i <= R+1; i++) {
			for(int j = 0; j <= C+1; j++) {
				sub[i][j] = map[i][j];
			}
		}
		
		Queue<Node> q= new LinkedList<>();
		q.add(new Node(0, 0, 0));
		visited[0][0] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int y = n.y;
			int x = n.x;
			
			for(int i = 0; i < 4; i++) {
				int nr = y + dy[i];
				int nc = x + dx[i];
				
				if(nr < 0 || nc < 0 || nr >= R+2 || nc >= C+2) continue;
				if(visited[nr][nc] == 1) continue;
				if(n.cost == 1) continue;
				
				if(map[nr][nc] == 1) {
					q.add(new Node(nr, nc, n.cost+1));
				} else {
					q.add(new Node(nr, nc, 0));
				}
				map[nr][nc] = 0;
				visited[nr][nc] = 1;
			}
			
		}
		return sub;
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
