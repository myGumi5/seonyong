package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2231 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){

            int num = i;
            int dev = 10;
            int sum = 0;
            while(num != 0){
                sum += (num % dev) / (dev / 10);
                num -= num % dev;

                dev *= 10;
            }

            if((i + sum) == n){
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
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
    }
}
