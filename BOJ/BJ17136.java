package com.ssafy.coding.live20221006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17136 {
	static int N = 10, ans = Integer.MAX_VALUE;
	static int[][] map = new int[N][N];
	static ArrayList<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				list.add(new int[]{i, j});
			}
		}
		
		dfs(0, new int[N][N], 0, new int[] {0, 5, 5, 5, 5, 5});
		
		// ans 값이 초기값에서 변하지 않았다면, 색종이를 어떤 경우의 수로도 붙힐 수 없음
		if(ans == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(ans);

	}
	static void dfs(int depth, int[][] sub, int cnt, int[] arr) {
		// 백트레킹
		// 선택한 색종이가 이전에 값이 의해 구해준 색종이 갯수 보다 크다면 더 이상 탐색할 필요가 없다.
		if(cnt >= ans) return;
		
		// 종료조건
		if(depth == N * N) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		int r = list.get(depth)[0] , c = list.get(depth)[1];
		//int[][] copy = copy(sub);
		int[] copyArr = copyArr(arr);
		// 선택 안할 때, 색종이를 덮을 수 없는 공간과 이미 붙힌 공간은 선택할 수 없다.
		if(map[r][c] == 0 || map[r][c] == 2) {
			dfs(depth + 1, sub, cnt, copyArr);
		} else {
			// 선택할 때, 1~5사이즈를 가진 색종이를 붙히 수 있는지 탐색한다.
			// 붙힐 수 있다면 그만큼 붙힌 후 다음 과정으로 넘어간다.
			for (int i = 5; i >= 1; i--) {
				if(check(depth, i, map, copyArr)) continue;
				// 색종이를 붙힐 수 있다면 붙히고 그럴 수 없다면, 무시한다
				
				draw(depth, map, i, 2);
				// 색종이를 그린다.  
				copyArr[i]--;
				// 해당 번호에 맞는 색종이 갯수를 뺀다.
				dfs(depth + 1, sub, cnt+1, copyArr);
				copyArr[i]++;
				// 다음 탐색을 위해 색종의 갯수를 원상 복구한다.
				draw(depth, map, i, 1);
				// 다음 탐색을 위해 붙힌 색종이를 원상 복구한다.
			}
		}
		
		
	}
	
	private static int[] copyArr(int[] arr) {
		int [] newArr = new int[5+1];
		for(int i = 1; i <= 5; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}
	private static void draw(int depth, int[][] sub, int size, int a) {
		int r = list.get(depth)[0] , c = list.get(depth)[1];
		
		for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				sub[i][j] = a;
			}
		}
		
	}
	private static int[][] copy(int [][] sub) {
		int [][] copy = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				copy[i][j] = sub[i][j];
			}
		}
		
		return null;
	}
	private static boolean check(int depth, int size, int[][] sub, int[] copyArr) {
		if(copyArr[size] <= 0) return true;
		
		int r = list.get(depth)[0] , c = list.get(depth)[1];
		for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				if(i >= N || j >= N) return true;
				if(map[i][j] == 0 || map[i][j] == 2) return true;
			}
		}
		
		return false;
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
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
