package com.ssafy.coding.live20220816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL1828 {
	static int N;
	static int [][] arr;
	static int cnt, max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, (o1, o2)->{
			return o1[1] - o2[1];
		});
		
		
		cnt = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i][0] <= max) {
				if(arr[i][1] < max) {
					max = arr[i][1];
				}
				continue;
			} else {
				max = arr[i][1];
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
