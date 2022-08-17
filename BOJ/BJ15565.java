package com.ssafy.coding.live20220817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15565 {
	static int N, K, min = Integer.MAX_VALUE;
	static int[] arr;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		K = sc.nextInt();
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		twoPointer();
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	static void twoPointer() {
		int right = 0;
		int cnt = 0;
		
		for(int left = 0; left < N; left++) {
			while(cnt < K && right < N) {
				if(arr[right++] == 1) cnt++;
			}
			
			if(cnt == K) min = Math.min(right - left, min);
			if(arr[left] == 1) cnt--;
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
10 3
1 2 2 2 1 2 2 2 2 2

 */
