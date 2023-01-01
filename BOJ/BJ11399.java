package com.ssafy.algo.live20230101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ11399 {

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		
		int [] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int sum = arr[0];
		int wait = 0;
		for(int i = 1; i < n; i++) {
			wait += arr[i-1];
			sum += wait + arr[i];
		}
		
		System.out.println(sum);
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
				} catch(Exception e) {
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
