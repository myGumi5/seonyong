package com.ssfay.coding.live20220810;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16935 {
	static int N, M, R;
	static int[] C;
	static int[][] map;
	
	public static void main(String[] args) {
		input();
		for(int r = 0; r < R; r++) {
			if(C[r] == 1) upDown();
			else if(C[r] == 2) leftRight();
			else if(C[r] == 3) rotationRight();
			else if(C[r] == 4) rotationLeft();
			else if(C[r] == 5) partitionRight();
			else if(C[r] == 6) partitionLeft();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void swap1(int i, int j, int cnt) {
		int y = N - cnt - 1;
		
		int temp = map[i][j];
		map[i][j] = map[y][j];
		map[y][j] = temp;
	}
	
	static void swap2(int i, int j, int cnt) {
		int x = M - cnt - 1;
		
		int temp = map[i][j];
		map[i][j] = map[i][x];
		map[i][x] = temp;
	}
	
	static void upDown() {
		int cnt = 0;
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M; j++) {
				swap1(i, j, cnt);
			}
			cnt++;
		}
	}
	
	static void leftRight() {
		int cnt = 0;
		for(int j = 0; j < M / 2; j++) {
			for(int i = 0; i < N; i++) {
				swap2(i, j, cnt);
			}
			cnt++;
		}
	}
	
	static void rotationRight() {
		int [][] copy = new int [M][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[j][N - i -1] = map[i][j];
			}
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		map = copy;
	}
	
	static void rotationLeft() {
		int [][] copy = new int [M][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[j][i] = map[i][M-j-1];
			}
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		map = copy;
	}
	
	static void partitionRight() {
		int [][] copy = new int [N][M];
		
		int x =0;
		int y =0;
		
		if(N % 2 == 0) {
			y = N / 2;
		} else {
			y = N / 2 + 1;
		}
		if(M % 2 == 0) {
			x = M / 2;
		} else {
			x = M / 2 + 1;
		}
		
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++) {
				copy[i][j+x] = map[i][j];
			}
		}
		for(int i = 0; i < N / 2; i++) {
			for(int j = x; j < M; j++) {
				copy[i+y][j] = map[i][j];
			}
		}
		for(int i = y; i < N; i++) {
			for(int j = x; j < M; j++) {
				copy[i][j - x] = map[i][j];
			}
		}
		for(int i = y; i < N; i++) {
			for(int j = 0; j < M / 2; j++) {
				copy[i - y][j] = map[i][j];
			}
		}
		
		if(M % 2 == 1) {
			for(int i = 0; i < N; i++) {
				copy[i][M / 2] = map[i][M / 2];
			}
		}
		if(N % 2 == 1) {
			for(int i = 0; i < M; i++) {
				copy[N / 2][i] = map[N / 2][i];
			}
		}
		
		map = copy;
	}
	static void partitionLeft() {
		int [][] copy = new int [N][M];
		
		int x =0;
		int y =0;
		
		if(N % 2 == 0) {
			y = N / 2;
		} else {
			y = N / 2 + 1;
		}
		if(M % 2 == 0) {
			x = M / 2;
		} else {
			x = M / 2 + 1;
		}
		
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++) {
				copy[i+y][j] = map[i][j];
			}
		}
		for(int i = 0; i < N / 2; i++) {
			for(int j = x; j < M; j++) {
				copy[i][j-x] = map[i][j];
			}
		}
		for(int i = y; i < N; i++) {
			for(int j = x; j < M; j++) {
				copy[i-y][j] = map[i][j];
			}
		}
		for(int i = y; i < N; i++) {
			for(int j = 0; j < M / 2; j++) {
				copy[i][j+x] = map[i][j];
			}
		}
		
		if(M % 2 == 1) {
			for(int i = 0; i < N; i++) {
				copy[i][M / 2] = map[i][M / 2];
			}
		}
		if(N % 2 == 1) {
			for(int i = 0; i < M; i++) {
				copy[N / 2][i] = map[N / 2][i];
			}
		}
		
		map = copy;
	}
	static void input() {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		C = new int[R];
		for(int i = 0; i < R; i++) {
			C[i] = sc.nextInt();
		}
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
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

/*
3 3 2
1 2 3
4 5 6
7 8 9
3 4
 */
