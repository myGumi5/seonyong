package com.ssafy.coding.live20220910;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2146 {
	static int N, min;
	static int[][] map, visited;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		map = new int[N][N];
		visited = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visited = new int[N][N];
				if(map[i][j] == 1) {
					bfs(i, j);
					
//					for(int z = 0; z < N; z++) {
//						System.out.println(Arrays.toString(visited[z]));
//					}
				}
			}
		}
		
		System.out.println(min);
		
	}
	static void bfs(int y, int x) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(y, x, 1));
		visited[y][x] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.dist != 1 && map[n.y][n.x] == 1) {
				
				min = Math.min(min, n.dist-1);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int r = n.y + dy[i];
				int c = n.x + dx[i];
				
				if(r < 0 || r >= N || c < 0 || c >= N) continue;
				if(visited[r][c] >= 1) continue;
			
				if(map[r][c] == 1) {
					visited[r][c] = n.dist;
					q.add(new Node(r, c, n.dist));
				} else {
					visited[r][c] = n.dist+1;
					q.add(new Node(r, c, n.dist+1));
				}
				
				
			}
			
		}
	}
	
	static class Node implements Comparable<Node>{
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

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}
		
		
	}
	
	static class FastReader {
		BufferedReader br = null;
		StringTokenizer st = null;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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
	}
}
