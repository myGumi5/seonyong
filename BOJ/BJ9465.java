package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9465 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();

        for(int t = 0; t < T; t++){
            int n = sc.nextInt();

            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for(int i = 0; i < 2; i++){
                for(int j = 1; j <= n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for(int j = 2; j <= n; j++){
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }

    }

    static class FastReader{
        BufferedReader br = null;
        StringTokenizer st = null;

        public FastReader(){
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

    }
}
