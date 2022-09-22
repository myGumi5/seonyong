package com.ssafy.coding.live20220923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1952 {
	static int T, cnt, ans; 
	static int[] cost, plan, visited;
	static ArrayList<Integer> list = null;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			cnt = 0;
			ans = Integer.MAX_VALUE;
			visited = new int[12+1];
			list = new ArrayList<>();
			cost = new int[4];
			for(int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
			}
			plan = new int[12+1];
			for(int i = 1; i <= 12; i++) {
				plan[i] = sc.nextInt();
				if(plan[i] != 0) {
					cnt++;
					list.add(i);
				}
			}
			
			permutation(new int[cnt+1], 1, 0);
			ans = Math.min(ans, cost[3]);
			System.out.printf("#%d %d\n", t+1, ans);
		}
		
	}
	static int calCost(int mode, int depth) {
		int sum = 0;
		if(mode == 0) {
			sum += cost[mode] * plan[list.get(depth-1)];
		} else {
			sum += cost[mode];
		}
		
		return sum;
	}
	
	static int calDepth(int mode) {
		int depth = 0;
		if(mode == 2) {
			depth = 3;
		} else {
			depth = 1;
		}
		
		return depth;
	}
	
	static void permutation(int [] per, int depth, int value) {
		if(depth >= cnt + 1) {
//			System.out.println(Arrays.toString(Arrays.copyOfRange(per, 1, depth)));
//			System.out.println(value);
			ans = Math.min(ans, value);
			return;
		}
		
		for(int i = 0; i <= 2; i++) {
			per[depth] = i;
			
		
			// 월간 ,일간 일정에 따른 값 계산 함수
			value += calCost(per[depth], depth);
			if(value >= ans) {
				value -= calCost(per[depth], depth);
				continue;
			}
			permutation(per, depth+calDepth(per[depth]), value);
			value -= calCost(per[depth], depth);
		}
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
/*

1     
10 40 100 300   
0 0 2 9 1 5 0 0 0 0 0 0

1     
10 100 50 300   
0 0 0 0 0 0 0 0 6 2 7 8

*/
