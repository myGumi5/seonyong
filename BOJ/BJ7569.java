package com.ssafy.coding.live20220830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ7569 {
	static int N, M, Z;
	static int[][][] map, visited;

	static ArrayList<Node> list = new ArrayList<>();
	
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	
	static class Node {
		int y, x, z, dist;

		public Node(int z, int y, int x, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.z = z;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", z=" + z + ", dist=" + dist + "]";
		}

	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		Z = sc.nextInt();
		
		map = new int[Z][M][N];
		visited = new int[Z][M][N];
		for (int z = 0; z < Z; z++) {
			for (int y = 0; y < M; y++) {
				for (int x = 0; x < N; x++) {
					map[z][y][x] = sc.nextInt();
					if(map[z][y][x] == 1) list.add(new Node(z, y, x, 1));
				}
			}
		}
		bfs();
		
		int max = Integer.MIN_VALUE;
		for (int z = 0; z < Z; z++) {
			for (int y = 0; y < M; y++) {
				for (int x = 0; x < N; x++) {
					if(map[z][y][x] == -1) continue;
					if(visited[z][y][x] == 0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(max, visited[z][y][x]);
				}
			}
		}
		
		System.out.println(max-1);
		
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for(Node n : list) {
			q.add(n);
			visited[n.z][n.y][n.x] = 1;
		}
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i = 0; i < 6; i++) {
				int r = n.y + dy[i];
				int c = n.x + dx[i];
				int z = n.z + dz[i];
				
				if(r < 0 || r >= M || c < 0 || c >= N || z < 0 || z >= Z) continue;
				if(map[z][r][c] == -1) continue;
				if(visited[z][r][c] >= 1) continue;
				
				
				visited[z][r][c] = n.dist + 1;
				q.add(new Node(z, r, c, n.dist+1));
			}
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
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

	}
}
