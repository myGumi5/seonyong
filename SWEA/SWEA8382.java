package com.ssafy.algo.live20221111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA8382 {
	static int T, sx, sy, ax, ay;
	static boolean[][][] visited;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			sx = sc.nextInt() + 100;
			sy = sc.nextInt() + 100;
			ax = sc.nextInt() + 100;
			ay = sc.nextInt() + 100;

			visited = new boolean[2][201][201];
			int ans = bfs();
			
			System.out.println("#"+t+" "+ans);
		}

	}

	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sy, sx, 0, 0));
		q.add(new Node(sy, sx, 1, 0));
		visited[0][sy][sx] = true;
		visited[1][sy][sx] = true;
		// 가로 방향으로 해당 좌표에 도착했을 때와
		// 세로 방향으로 해당 좌표에 도착했을 때를 체크한다.
		

		while (!q.isEmpty()) {
			Node n = q.poll();
			int r = n.y;
			int c = n.x;

			if(r == ay && c == ax) {
				return n.dist;
			}
			
			for (int d = 0; d < 4; d++) {
				if(check(d, n.dir)) {
					int nr = r + dy[d];
					int nc = c + dx[d];
					
					// 범위를 벗어나면 무시
					if(nr < 0 || nc < 0 || nr >= 201 || nc >= 201) continue;
					// 해당 노드가 좌표에 같은 방향으로 이미 방문한 곳이면 무시
					if(visited[d%2][nr][nc]) continue;
					
					// 이동하려는 좌표와 이동하려는 방향을 체크한다
					q.add(new Node(nr, nc, d%2, n.dist+1));
					visited[d%2][nr][nc] = true;
				}
			}
		}
		return -1;
	}

	private static boolean check(int d, int dir) {
		// d가 짝수 일 때, dir는 홀 수이어야만 가능 
		if(d % 2 == 0 && dir % 2 == 1) {
			return true;
		// d가 홀 수 일 때, dir는 짝 수이어야만 가능
		} else if(d % 2 == 1 && dir % 2 == 0) {
			return true;
		}
		
			
		return false;
	}

	static class Node {
		int y, x, dir, dist;

		public Node(int y, int x, int dir, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", dir=" + dir + ", dist=" + dist + "]";
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

		String nextLine() {
			String str = null;
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
