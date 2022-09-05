package com.ssafy.coding.live20220905;

import java.io.*;
import java.util.*;

public class BJ9084 {
	static int T;
	static int[] arr1;
	static int dp[][];

	public static void main(String[] args) {
		FastReader sc = new FastReader();

		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int num = sc.nextInt();

			arr1 = new int[num + 1];
			for (int i = 1; i <= num; i++) {
				arr1[i] = sc.nextInt();
			}

			int target = sc.nextInt();
			dp = new int[num + 1][target + 1];
			for(int j = 1; j <= target; j++) {
				if (arr1[1] > j) continue;
				if (j % arr1[1] == 0) dp[1][j] = 1;
				else dp[1][j] = 0;
			}
			
			for (int i = 2; i <= num; i++) {
				for (int j = 1; j <= target; j++) {
					if (arr1[i] > j) {
						dp[i][j] = dp[i-1][j];
						continue;
						
					} else if(arr1[i] == j) {
						dp[i][j] = dp[i-1][j] + 1;
						continue;
					}
					
					
					dp[i][j] = dp[i - 1][j] + dp[i][j  - arr1[i]];
					
				}
			}
/*
			for (int j = 0; j <= target; j++) {	
				System.out.printf("%4d ", j);
			}
			System.out.println();
			for (int j = 0; j <= target; j++) {	
				System.out.printf("%4d ", dp[num-1][j]);
			}
			System.out.println();
			for (int j = 0; j <= target; j++) {	
				System.out.printf("%4d ", dp[num][j]);
			}
			System.out.println();
			*/
			System.out.println(dp[num][target]);

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
	}

}
