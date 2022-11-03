package com.ssafy.coding.live20221103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3967 {
	static int R = 5, C = 9;
	
	static ArrayList<int[]> list;
	static boolean[] visited, check;
	static boolean flag;
	
	static char[][] map;
	
	static char[] arr = {'?','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' ,'K' ,'L'};
						//	  1	   2    3    4    5    6    7    8    9    10   11   12
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		map = new char[R][C];
		check = new boolean[12+1];
		list = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] != '.') {
					if(map[i][j] == 'x') {
						list.add(new int[] {i, j});
					} else {
						int num = map[i][j] - 'A' + 1;
						check[num] = true;
					}
				}
			}
		}
		
		visited = new boolean[list.size()];
		dfs(0);
		
		
	}
	
	static void dfs(int depth) {
		if(flag) return;
		
		if(depth == list.size()) {
//			if(map[0][4] == 'F' && map[1][7] == 'L' &&
//					map[2][2] == 'H' && map[2][6] == 'E' &&
//					map[3][1] == 'C' && map[3][3] == 'J' &&
//					map[3][5] == 'B' && map[3][7] == 'K') {
//				System.out.println("start");
//				
//			}
			
			if(check()) {		
				flag = true;
				for (int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
			}
			return;
		}
		
		int r = list.get(depth)[0];
		int c = list.get(depth)[1];
		for(int i = 1; i <= 12; i++) {
			if(!check[i]) {
				check[i] = true;
				map[r][c] = arr[i];
				dfs(depth+1);
				check[i] = false;
				map[r][c] = 'x';
			}
		}
		
	}
	
	private static boolean check() {
		// 우
		int sum = 0;
		for(int i = 0; i < 8; i+=2) {
			sum += map[1][1+i] - 'A' + 1;
		}
		
		if(sum != 26) return false;
		
		// 하우
		sum = 0;
		for(int i = 0; i < 4; i++) {
			sum += map[1+i][1+i] - 'A' + 1;
		}
		if(sum != 26) return false;
		
		// 하좌
		sum = 0;
		for(int i = 0; i < 4; i++) {
			sum += map[1+i][7-i] - 'A' + 1;
		}
		if(sum != 26) return false;
		
		// 하 우
		sum = 0;
		for(int i = 0; i < 4; i++) {
			sum += map[0+i][4+i] - 'A' + 1;
		}
		if(sum != 26) return false;
		
		// 하 좌
		sum = 0;
		for(int i = 0; i < 4; i++) {
			sum += map[0+i][4-i] - 'A' + 1;
		}
		if(sum != 26) return false;
		
		// 우
		sum = 0;
		for(int i = 0; i < 8; i+=2) {
			sum += map[3][1+i] - 'A' + 1;
		}
		if(sum != 26) return false;
		
		
		return true;
	}

	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		};
		
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
