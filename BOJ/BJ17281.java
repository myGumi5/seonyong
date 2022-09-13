package com.ssafy.coding.live20220913;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17281 {
	static int N, ans = Integer.MIN_VALUE, present = 1;
	static int[] visited;
	static int[][] pre_arr;
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();

		visited = new int[9 + 1];
		pre_arr = new int[N + 1][9 + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 9; j++) {
				pre_arr[i][j] = sc.nextInt();
			}
		}
		// input process

		// 타순을 정한다.
		permutation(new int[8+1], 1);

//		for (int i = 0; i < 2; i++)
//			System.out.println(Arrays.toString(list.get(i)));
		
		System.out.println(ans);
	}

	static void permutation(int[] arr, int depth) {
		if (depth >= 9) {
			// 타순 다 정했으면 게임 시작
			play(arr);
			//System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = 2; i <= 9; i++) {
			if (visited[i] == 1)
				continue;
			arr[depth] = i;	
			visited[i] = 1;
			permutation(arr, depth + 1);
			visited[i] = 0;
		}
	}

	static void play(int[] seq) {
		int point = 0;
		present = 1;
		
		for(int i = 1; i <= N; i++) {
			point += process(seq, i);
		}
		
		ans = Math.max(ans, point);
		
	}

	static int process(int [] seq, int now) {
		int outCount = 0;
		int point = 0;
		int i = present;
		
		boolean[] base = new boolean[4];
		
		while(outCount < 3) {
			if(i >= 10) {
				i = 1;
				present = 1;
			}
			int num = 0;
			
			if(i < 4) num = seq[i];
			else if(i == 4) num = 1;
			else num = seq[i-1];
				
			int val = pre_arr[now][num];
			switch (val) {
			case 4 : 
				if(base[3]) {
					point++;
					base[3] = false;
				}
				if(base[2]) {
					point++;
					base[2] = false;
				}
				if(base[1]) {
					point++;
					base[1] = false;
				}
				point++;
				break;
			case 3 : 
				if(base[3]) {
					point++;
					base[3] = false;
				}
				if(base[2]) {
					point++;
					base[2] = false;
				}
				if(base[1]) {
					point++;
					base[1] = false;
				}
				base[3] = true;
				break;
			case 2 : 
				if(base[3]) {
					point++;
					base[3] = false;
				}
				if(base[2]) {
					point++;
					base[2] = false;
				}
				if(base[1]) {
					base[3] = true;
					base[1] = false;
				}
				base[2] = true;
				break;
			case 1 :
				if(base[3]) {
					point++;
					base[3] = false;
				}
				if(base[2]) {
					base[3] = true;
					base[2] = false;
				}
				if(base[1]) {
					base[2] = true;
					base[1] = false;
				}
				base[1] = true;
				break;
			default:
				outCount++;
				break;
			}
			
			i++;
			present++;
		}
		return point;
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

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
