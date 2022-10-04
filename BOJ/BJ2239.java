package com.ssafy.coding.live20221004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2239 {
	static int[][] map, map1;
	static int cnt = 0;
	static boolean flag = false;
	static ArrayList<int[]> list = new ArrayList<>();
	/*
143628579
572139468
986754231
391542786
468917352
725863914
237481695
619275843
854396127
	 */
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		map = new int[9][9];
		for(int i = 0; i < 9; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
				list.add(new int[] {i, j});
			}
		}

		dfs(0, map);
		
	}
	
	static void dfs(int depth, int[][] copy) {
		if(depth == 81) {
			flag = true;

			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(copy[i][j]);
				}
				System.out.println();
			}
			return;
		}
		
		if(flag) return;
			
		int[][] sub = copy(copy); // 새로운 배열 생성
		
		if(isEmpty(depth)) {
			dfs(depth + 1, copy);
		}else {		
			for (int i = 1; i <= 9; i++) {
				addNumber(sub, depth, i); // 숫자 추가
				if(check(sub, depth)) continue;
				dfs(depth + 1, sub);
				//deleteNumber(sub, copy);			// 숫자 제거
			}
		}
	}
	
	private static boolean check(int [][] sub, int depth) {
		int r = list.get(depth)[0];
		int c = list.get(depth)[1];
		
		int[] arr = new int[9+1];
		// 행탐색
		for (int j = 0; j < 9; j++) {
			arr[sub[r][j]]++;
		}
		for (int j = 0; j < 9; j++) {
			if (arr[j + 1] >= 2)
				return true;
		}
		
		arr = new int[9+1];
		// 열탐색
		for (int j = 0; j < 9; j++) {
			arr[sub[j][c]]++;
		}
		for (int j = 0; j < 9; j++) {
			if (arr[j + 1] >= 2)
				return true;
		}

		if(r <= 2) r = 0;
		else if(r <= 5) r = 3;
		else r = 6;
		
		if(c <= 2) c = 0;
		else if(c <= 5) c = 3;
		else c = 6;
		arr = new int[9+1];
		// 9칸 탐색
		for(int i = r * 9; i <= (r + 2) * 9; i+=9) {
			for(int j = c; j <= c+2; j++) {
				int a = list.get(i+j)[0];
				int b = list.get(i+j)[1];
				arr[sub[a][b]]++;
			}
		}
		/*
		 6, 0, 0
		 1, 0, 9
		 7, 0, 4
		 */
		
		for(int i = 1; i <= 9; i++) {
			if(arr[i] >= 2) return true;
		}
		
		return false;
	}

	private static void deleteNumber(int[][] sub, int[][] copy) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sub[i][j] = copy[i][j];
			}
		}
	}

	private static boolean isEmpty(int depth) {
		int [] arr = list.get(depth);
		int r = arr[0];
		int c = arr[1];
		
		if(map[r][c] == 0) return false;
		
		return true;
	}

	private static void addNumber(int [][] sub, int depth, int i) {
		int [] arr = list.get(depth);
		int r = arr[0];
		int c = arr[1];
		
		sub[r][c] = i;
	}

	private static int[][] copy(int [][] copy) {
		int [][] sub = new int[9][9];
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sub[i][j] = copy[i][j];
			}
		}
		
		return sub;
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		String nextLine() {
			String str = null;
			
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return str;
		}
	}
}
