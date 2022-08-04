package com.ssafy.coding.BJ20220804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14499 {
	static int N, M, x, y, K;
	static int[] command;
	static int[][] map;
	
	static LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0,0,0,0));
	static int wst = 0, est = 0;
	
	public static void main(String[] args) {
		intput();
		
		for(int i : command) {
			boolean check = rollingDice(i);
			if(check) {
				printDice();
				copyNum();
			}
		}
	}
	
	static void printDice() {
		System.out.println(list.get(1));
	}
	
	static void copyNum() {
		if(map[x][y] == 0) {
			map[x][y] = list.get(3);
		} else {
			list.remove(3);
			list.add(map[x][y]);
			map[x][y] = 0;
		}
	}
	
	static boolean rollingDice(int dir) {
		// ³²
		if(dir == 4) {
			if(x + 1 >= N) return false;
			list.add(0, list.remove(list.size()-1));
			x += 1;
			return true;
		// ºÏ
		} else if(dir == 3) {
			if(x - 1 < 0) return false;
			list.add(list.remove(0));
			x -= 1;
			return true;
		// ¼­
		} else if(dir == 2) {
			if(y - 1 < 0) return false;
			int temp = wst;
			wst = list.get(1);
			list.remove(1);
			list.add(1, est);
			est = list.remove(3);
			list.add(temp);
			y -= 1;
			return true;
		// µ¿
		} else if(dir == 1) {
			if(y + 1 >= M) return false;
			int temp = est;
			est = list.get(1);
			list.remove(1);
			list.add(1, wst);
			wst = list.get(3);
			list.remove(3);
			list.add(temp); 
			y += 1;
			return true;
		}
		
		return false;
	}
	
	static void intput() {
		FastReader sc = new FastReader();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		x = sc.nextInt();
		y = sc.nextInt();
		
		K = sc.nextInt();
		command = new int[K];
		
		map = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < K; i++) {
			command[i] = sc.nextInt();
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
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}

	}
}
