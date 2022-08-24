package com.ssafy.coding.live20220823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ7576 {
	static int N, M;
	static int [][] map, visited;
	static ArrayList<int []> list = new ArrayList<>();
	
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[N][M];
		visited = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					list.add(new int[] {i, j});
				}
				if(map[i][j] == -1) visited[i][j] = -1;
			}
		}
		
		bfs();
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max =  Math.max(max, visited[i][j]);
			}
		}
		
		System.out.println(max-1);
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
//		System.out.println();
		
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for(int [] arr : list) {
			int n1 = arr[0];
			int n2 = arr[1];
			
			q.add(new Node(n1, n2, 1));
			visited[n1][n2] = 1;
		}
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int r = n.y + dy[i];
				int c = n.x + dx[i];
				
				if(r < 0 || r >= N || c < 0 || c>= M) continue;
				if(visited[r][c] >= 1) continue;
				if(map[r][c] == -1) continue;
				
				visited[r][c] = n.dist + 1;
				q.add(new Node(r, c, n.dist+1));
			}
		}
		
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
				}
			}
			
			return st.nextToken();
		}
		
		String nextLine() {
			String str = null;
			try {
				str = br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return str;
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

