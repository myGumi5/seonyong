package com.ssafy.coding.live20220820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16235 {
	static int N, M, K;
	static int[][] A, copy;
	static Queue<Tree> coor, sub;
					//¿À  ¿Þ   »ó ÇÏ , ÇÏÁÂ »ó¿ì »óÁÂ ÇÏ¿ì
	static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
	static int[] dx = {1, -1, 0, 0, -1, 1, -1, 1};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		A = new int[N][N];
		copy = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				A[i][j] = 5;
				copy[i][j] = sc.nextInt();
			}
		}
		
		coor = new LinkedList<>();
		sub = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int num3 = sc.nextInt();
			
			coor.add(new Tree(num2-1, num1-1, num3));
		}
		
		
		
		pro();
		
		int cnt = 0;
		int len = coor.size();
		for(int i = 0; i < len; i++) {
			Tree t = coor.poll();
			if(!t.isDie) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	
	
	private static void pro() {
		int num = 0;
		while(num < K) {
			spring();
			summer();
			fall();
			winter();
			
			num++;
		}
		
	}



	private static void winter() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				A[i][j] += copy[i][j];
			}
		}
		
	}



	private static void fall() {
		int len = coor.size();
		for(int i = 0; i < len; i++) {
			Tree t = coor.poll();
			sub.add(t);
			if(t.age % 5 != 0) continue;
			if(t.isDie) continue;
			int r = t.x;
			int c = t.y;
			
			for(int j = 0; j < 8; j++) {
				int ry = r + dy[j];
				int cx = c + dx[j];
				
				if(ry < 0 || ry >= N || cx < 0 || cx >= N) continue;
				coor.add(new Tree(ry, cx, 1));
			}
			
			
		}
		int l = sub.size();
		for(int i = 0; i < l; i++) {
			coor.add(sub.poll());
		}
	}



	private static void summer() {
		int len = coor.size();
		for(int i = 0; i < len; i++) {
			Tree t = coor.poll();
			if(t.isDie) {
				A[t.y][t.x] += (t.age / 2);
			} else {
				coor.add(t);
			}
		}
		
	}



	private static void spring() {
		int len = coor.size();
		for(int i = 0; i < len; i++) {
			Tree t = coor.poll();
			coor.add(t);
			
			if(A[t.y][t.x] - t.age >= 0) {
				A[t.y][t.x] -= t.age;
				t.age += 1;
			} else {
				t.isDie = true;
			}
		}
	}

	static class Tree implements Comparable<Tree>{
		int x, y, age;
		boolean isDie;
		
		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
		
		

		@Override
		public String toString() {
			return "Tree [y=" + y + ", x=" + x + ", age=" + age + "]";
		}



		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
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


/*
5 2 7
2 3 2 3 2
2 3 2 3 2
2 3 2 3 2
2 3 2 3 2
2 3 2 3 2
2 1 3
3 2 3
 */
