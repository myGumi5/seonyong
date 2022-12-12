package com.ssafy.algo.live20221212;

import java.io.*;
import java.util.*;

public class BJ14442 {
	static int N, M, K;
	static int[][] map;
	static int[][][] visited;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][M];
		visited = new int[K+1][N][M];
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - 48;
			}
		}
		
		bfs();
		
		
	}
	static void bfs() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0, 1, 1));
		visited[0][0][0] = 11;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int r = n.y;
			int c = n.x;
			int k = n.cnt;
			
			if(r == (N-1) && c == (M-1)) {
				System.out.println(n.dist);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dy[d];
				int nc = c + dx[d];
				
				if(nr < 0|| nc < 0 || nr >= N || nc >= M) continue;
				if(visited[0][nr][nc] != 0 && visited[0][nr][nc] > k) {
					if(map[nr][nc] == 1) {
						if(k >= K+1) continue;	
						visited[0][nr][nc] = k+1;
						q.add(new Node(nr, nc, k+1, n.dist + 1));
					} else {
						visited[0][nr][nc] = k;
						q.add(new Node(nr, nc, k, n.dist + 1));
					}
					continue;
				}
				if(visited[0][nr][nc] >= 1) continue;
				
				if(map[nr][nc] == 1) {
					if(k >= K+1) continue;	
					visited[0][nr][nc] = k+1;
					q.add(new Node(nr, nc, k+1, n.dist + 1));
				} else {
					visited[0][nr][nc] = k;
					q.add(new Node(nr, nc, k, n.dist + 1));
				}
			}
			
		}
		
		System.out.println(-1);
	}
	
	
	static class Node implements Comparable<Node>{
		int y, x, cnt, dist;
		
		
		
		public Node(int y, int x, int cnt, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dist = dist;
		}



		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}

	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader(){
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

// 3차원 배열 버전
/*
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[][][] visited;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][M];
		visited = new int[K+1][N][M];
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - 48;
			}
		}
		
		bfs();
		
		
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, 1));
		visited[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int r = n.y;
			int c = n.x;
			int k = n.cnt;
			
			if(r == (N-1) && c == (M-1)) {
				System.out.println(n.dist);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dy[d];
				int nc = c + dx[d];
				
				if(nr < 0|| nc < 0 || nr >= N || nc >= M) continue;
				if(visited[k][nr][nc] == 1) continue;
				
				if(map[nr][nc] == 1) {
					if(k >= K) continue;	
					visited[k][nr][nc] = 1;
					q.add(new Node(nr, nc, k+1, n.dist + 1));
				} else {
					visited[k][nr][nc] = 1;
					q.add(new Node(nr, nc, k, n.dist + 1));
				}
			}
			
		}
		
		System.out.println(-1);
	}
	
	
	static class Node implements Comparable<Node>{
		int y, x, cnt, dist;
		
		
		
		public Node(int y, int x, int cnt, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dist = dist;
		}



		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}

	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader(){
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



*/
