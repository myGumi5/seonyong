package com.ssafy.coding.live20220817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1931 {
	static int N, max, cnt;
	static int [][] arr;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		 N = sc.nextInt();
		 
		 
		 arr = new int[N][2];
		 for(int i = 0; i < N; i++) {
			 arr[i][0] = sc.nextInt();
			 arr[i][1] = sc.nextInt();
		 }
		 
		 Arrays.sort(arr, (o1, o2) -> {
			 if(o1[1] == o2[1]) return o1[0] - o2[0];
			 return o1[1] - o2[1];
		 });
		
		 cnt = 1;
		 max = arr[0][1];
		 for(int i = 1; i < N; i++) {
			 if(max <= arr[i][0]) {
				 max = arr[i][1];
				 //System.out.println(Arrays.toString(arr[i]));
				 cnt++;
			 }
		 }
		 
		 System.out.println(cnt);
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
