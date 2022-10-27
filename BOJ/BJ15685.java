package com.ssafy.algo.live20221027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ15685 {
	static int P = 100, N, cnt;
	static boolean[][] map; 

	static Queue<Node> q;
	static ArrayList<Integer> list;
	
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		map = new boolean[P+1][P+1];
		q = new LinkedList<>();
		
		cnt = 0;
		N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			q.add(new Node(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		
//		while(!q.isEmpty()) {
//			Node n = q.poll();
//			
//			list = new ArrayList<>();
//			getDir(n.g, n.d);
//			curve(n.y, n.x);
//			
//		}
//		
//		for(int i = 0; i < P; i++)
//			System.out.println(Arrays.toString(map[i]));
		
		pro();
		System.out.println(cnt);
	}
	
	static void pro() {
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			list = new ArrayList<>();
			getDir(n.g, n.d);
			curve(n.y, n.x);
		}
		check();
	}
	
	private static void check() {
		for(int i = 0; i < P ; i++) {
			for(int j = 0; j < P; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					cnt++;
				}
			}
		}
	}

	private static void curve(int y, int x) {
		map[y][x] = true;
		for(int i = 0; i < list.size(); i++) {
			int dir = list.get(i);
			
			y += dy[dir];
			x += dx[dir];
			map[y][x] = true;
		}
		
	}

	private static void getDir(int g, int d) {
		list.add(d);
		
		for(int t = 0; t < g; t++) {
			for (int i = list.size() - 1; i >= 0; i--) {
				int num = list.get(i);

				num = (num + 1) % 4;
				list.add(num);
			}
		}
	}

	static class Node{
		int x, y, d, g;

		public Node(int x, int y, int d, int g) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", d=" + d + ", g=" + g + "]";
		}
		
		
	}
	
	static class FastReader	{
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
