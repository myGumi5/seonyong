package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1978 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        boolean [] arr = new boolean[1001];

        arr[1] = true;
        for(int i = 2; i < 1001; i++){
            for(int j = i + i; j < 1001; j += i){
                arr[j] = true;
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
//            if(arr[i]) System.out.println(i);
            if(!arr[sc.nextInt()]) cnt++;
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
