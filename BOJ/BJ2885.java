package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2885 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int K = sc.nextInt();


        int size = 1;
        int sub = 0;
        while(size < K){
            size *= 2;
            sub = size;
        }

        int cnt = 0;
        while(K > 0){
            if(K>=sub){
                K -= sub;
            } else{
                sub /= 2;
                cnt++;
            }
        }

        System.out.println(size+" "+cnt);

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
