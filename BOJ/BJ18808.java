package com.ssafy.coding.live20220818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BJ18808 {
	static int N, M, K, cnt, r, c;
	static int [][] map;
	static LinkedList<int [][]> q = new LinkedList<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][M];
		for(int i = 0; i < K; i++) {
			r = sc.nextInt();
			c = sc.nextInt();
			cnt = 0;
			int [][] stiker = new int[r][c];
			for(int j = 0; j < r; j++) {
				for(int z = 0; z < c; z++) {
					stiker[j][z] = sc.nextInt();
				}
			}
			q.add(stiker);
			while(!q.isEmpty()) {
				int[][] sk = q.poll();
				takeStiker(sk);
				/*
				for (int i = 0; i < N; i++) {
					System.out.println(Arrays.toString(map[i]));
				}
				System.out.println();
				*/
			}
		}
		// input process
		
		
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1)
					count++;
			}
		}
		System.out.println(count);
	}
	static void takeStiker(int [][] sk) {
		for(int i = 0; i < N - (sk.length - 1); i++) {
			for(int j = 0; j < M - (sk[0].length - 1); j++) {
				// 스티커 붙히기 가능
				if (isAvailable(i, j, sk)) {
					takeStiker(i, j, sk);
					return;
				}
			}
		}
		
		// 모든 구역 스티커 붙히기 불가능 일때,
		// 이미 270도를 회전하였다면, 
		if(cnt == 3) {
			cnt = 0;
			return;
		}
		
		rolling(sk);
		cnt++;
		
	}
	static void rolling(int [][] sk) {
		int [][] copy = new int [c][r];
		
		for(int i = 0; i < c; i++) {
			int num = 0;
			for(int j = r-1; j >= 0; j--) {
				copy[i][num++] = sk[j][i];
			}
		}
		
		int temp = r;
		r = c;
		c = temp;
		q.add(0, copy);
	}
	
	static boolean isAvailable(int i, int j, int[][] sk) {
		for(int y = 0; y < r; y++) {
			for(int x = 0; x < c; x++) {
				if(sk[y][x] == 1 && map[y+i][x+j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void takeStiker(int i, int j, int[][] sk) {
		for(int y = 0; y < r; y++) {
			for(int x = 0; x < c; x++) {
				if(sk[y][x] == 1) map[y+i][x+j] = sk[y][x];
			}
		}
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st ==null || !st.hasMoreElements()) {
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

/*

5 4 3
3 3
1 0 1
1 1 1
1 0 1
2 5
1 1 1 1 1
0 0 0 1 0
2 3
1 1 1
1 0 1



3 3 2
3 3
1 1 1
1 1 1
1 1 1
2 2 
1 1
0 1


1 3 1
2 3
1 0 0
1 1 1



*/