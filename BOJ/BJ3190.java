package com.ssafy.coding.live20220821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ3190 {
	static int N, K, L;
	static int[][] map;
	
	static Deque<Snake> dq = new ArrayDeque<>();
	static Queue<int []> q = new LinkedList<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		K = sc.nextInt();
		
		
		map = new int[N][N];
		for(int i = 0; i < K; i++) {
			map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
		}
		
		L = sc.nextInt();
		for(int i = 0; i < L; i++) {
			int[] sub = new int[2];
			sub[0] = sc.nextInt();
			sub[1] = (int)sc.nextChar();
			q.add(sub);
		}
		
		dq.add(new Snake(0, 0, 'E'));
		// input process
		
		pro();
	}
	
	static void pro() {
		int sec = 0;
		while(true){
			sec++;
			
			
			go();
			if(isCrush()) break;
			hasApple();
			
			if(!q.isEmpty() && q.peek()[0] == sec) {
				turn();
			} 
			
			
		}
		
		System.out.println(sec);
	}
	
	private static void hasApple() {
		Snake s = dq.peek();
		if(s.y < 0 || s.y >= N || s.x < 0 || s.x >= N) return;
		
		if(map[s.y][s.x] == 1) {
			map[s.y][s.x] = 0;
		} else {
			dq.pollLast();
		}
	}

	private static void go() {
		Snake s = dq.peek();

		if(s.dir == 'E') {
			dq.addFirst(new Snake(s.y, s.x+1, s.dir));
		} else if(s.dir == 'W'){
			dq.addFirst(new Snake(s.y, s.x-1, s.dir));
		} else if(s.dir == 'N'){
			dq.addFirst(new Snake(s.y-1, s.x, s.dir));
		} else if(s.dir == 'S'){
			dq.addFirst(new Snake(s.y+1, s.x, s.dir));
		}
	}

	private static void turn() {
		Snake s = dq.peek();
		int [] arr = q.poll();
		
		if(s.dir == 'E') {
			if(arr[1] == 68) {
				s.dir = 'S';
			} else {
				s.dir = 'N';
			}
		} else if(s.dir == 'W'){
			if(arr[1] == 68) {
				s.dir = 'N';
			} else {
				s.dir = 'S';
			}
		} else if(s.dir == 'N'){
			if(arr[1] == 68) {
				s.dir = 'E';
			} else {
				s.dir = 'W';
			}
		} else if(s.dir == 'S'){
			if(arr[1] == 68) {
				s.dir = 'W';
			} else {
				s.dir = 'E';
			}
		}
		
	}

	private static boolean isCrush() {
		Snake s = dq.poll();
		int len = dq.size();
		
		if(s.y < 0 || s.y >= N || s.x < 0 || s.x >= N) return true;
		for(int i = 0; i < len; i++) {
			Snake sub = dq.poll();
			if(sub.y == s.y && sub.x == s.x) return true;
			else {
				dq.add(sub);
			}
		}
		dq.addFirst(s);
		return false;
	}

	static class Apple{
		int y; int x;

		public Apple(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Apple [y=" + y + ", x=" + x + "]";
		}
		
	}
	
	static class Snake{
		int y; int x; char dir;






		public Snake(int y, int x, char dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}






		@Override
		public String toString() {
			return "Snake [y=" + y + ", x=" + x + ", dir=" + dir + "]";
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
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		char nextChar() {
			return next().charAt(0);
		}
		
	}
}
