package com.ssafy.coding.live20221009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1600 {
	static int K, W, H, ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[][][] visited;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int[] hdy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hdx = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
			K = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			map = new int[H][W];
			visited = new int[2][H][W];
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			bfs();
			if(ans == Integer.MAX_VALUE) 
				System.out.println(-1);
			else 
				System.out.println(ans);
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 1, 0));
		visited[0][0][0] = 1;
		visited[1][0][0] = 1;
		
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int y = n.y;
			int x = n.x;
			
			if(y == H-1 && x == W-1) {
				ans = Math.min(ans, n.dist);
				continue;
			}
			
			if(n.count <= K) {
				for (int d = 0; d < 8; d++) {
					int ny = y + hdy[d];
					int nx = x + hdx[d];

					if (ny < 0 || ny >= H || nx < 0 || nx >= W)
						continue;
					if (map[ny][nx] == 1)
						continue;
					if (visited[1][ny][nx] >= 1) {
						if(n.count + 1 >= visited[1][ny][nx])
							continue;
					}

					q.add(new Node(ny, nx, n.count+1, n.dist + 1));
					visited[1][ny][nx] = n.count+1;
				}
			}
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || ny >= H || nx < 0 || nx >= W)
					continue;
				if (map[ny][nx] == 1)
					continue;
				if (visited[0][ny][nx] >= 1) {
					if(n.count >= visited[0][ny][nx])
						continue;
				}
				q.add(new Node(ny, nx, n.count, n.dist + 1));
				visited[0][ny][nx] = n.count;
			}
		}
		
	}
	/*
1
4 4
0 0 0 0
1 0 0 0
0 0 1 1
0 1 0 0
	 */
	static class Node{
		int y, x, count, dist;

		

		public Node(int y, int x, int count, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.count = count;
			this.dist = dist;
		}



		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", count=" + count + "]";
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
