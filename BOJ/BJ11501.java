package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11501 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            int num = sc.nextInt();

            Integer[] arr = new Integer[num];
            for(int i = 0; i < num; i++){
                arr[i] = sc.nextInt();
            }

            long profit = 0;
            long max = 0;
            for(int i = num-1; i >= 0; i--){
                if(arr[i] > max){
                    max = arr[i];
                } else{
                    profit += max - arr[i];
                }
            }

            System.out.println(profit);

        }
    }
    static class FastReader{
        BufferedReader br = null;
        StringTokenizer st = null;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()) {
                try {
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

        String nextLine(){
            String str = null;
            try{
                str = br.readLine();
            } catch(Exception e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
