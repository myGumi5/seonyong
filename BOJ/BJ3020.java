package com.ssafy.coding.BJ3020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ3020 {
	static int N, H;
	static int[] arr1, arr2;
	
	static HashMap<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		N = sc.nextInt();
		H = sc.nextInt();
		
		int len = N / 2;
		if(N % 2 == 0) {
			arr1 = new int[N / 2];
		}
		else {
			arr1 = new int[N / 2 + 1];
			len += 1;
		}
		arr2 = new int[N / 2];
		
		for(int i = 0; i < len; i++) {
			arr1[i] = sc.nextInt();
			if(i < N / 2)
				arr2[i] = sc.nextInt();
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int min = Integer.MAX_VALUE;
		int cnt = 0;
		for(int i = 1; i <= H; i++){
			int first = binarySearch1(0, arr1.length - 1, i, arr1);
			int second = binarySearch1(0, arr2.length - 1, H-i-1, arr2);
			
			if(min > first+second) {
				min = first+second;
				cnt = 1;
			} else if(min == first+second) {
				cnt++;
			}
		}
		System.out.println(min+" "+cnt);
		
	}
	static int binarySearch1(int left, int right, int h, int[] arr) {
		int min = Integer.MAX_VALUE;
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] > h) {
				min = Math.min(min,  mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return min == Integer.MAX_VALUE ? 0 : (N/2) - min;
		
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader(){
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
