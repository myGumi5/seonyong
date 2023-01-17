package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2292 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int n = sc.nextInt();
        int high = 2;

        int num = 6;
        int cnt = 1;
        while(n >= high){
            cnt++;
            high += num;
            num += 6;
        }

        System.out.println(cnt);
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
