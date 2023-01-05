package com.ssafy.algo.live20230105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		int m = sc.nextInt();
		int[] sub = new int[m];
		for(int i = 0; i < m; i++) {
			sub[i] = sc.nextInt();
		}
		
		for(int i = 0; i < m; i++) {
			int num = sub[i];
			
			int left = 0;
			int right = n - 1;
			boolean flag = false;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				
				if(arr[mid] > num) {
					right = mid - 1;
				} else if(arr[mid] < num){
					left = mid + 1;
				} else {
					flag = true;
					break;
				}
			}
			
			if(flag) sb.append("1").append("\n");
			else sb.append("0").append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	static class FastReader{
        BufferedReader br = null;
        StringTokenizer st = null;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt(){
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
