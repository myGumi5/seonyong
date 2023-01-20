package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ24956 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int N = sc.nextInt();
        String str = sc.nextLine();

        int[] cnt_w = new int[N];
        if(str.charAt(0) == 'W'){
            cnt_w[0] = 1;
        }
        for(int i =1; i < N; i++){
            if(str.charAt(i) == 'W'){
                cnt_w[i] = cnt_w[i-1] + 1;
            } else{
                cnt_w[i] = cnt_w[i-1];
            }
        }

        int[] cnt_e = new int[N+1];
        for(int i = N-1; i>= 0; i--){
            if(str.charAt(i) == 'E'){
                cnt_e[i] = cnt_e[i+1] + 1;
            } else{
                cnt_e[i] = cnt_e[i+1];
            }
        }

        int[] two = new int[N+1];
        two[0] = 1;
        for(int i = 1; i <= N; i++){
            two[i] = two[i-1] * 2;
            two[i] %= 1000000007;
        }

        long ans = 0;
        for(int i = 0; i < N; i++){
            if(str.charAt(i) != 'H') continue;
            int w = cnt_w[i];
            int e = cnt_e[i];

            long l = (two[e] - (e% 1000000007) - (1% 1000000007)) % 1000000007;
            ans += (l * w);
            ans %= 1000000007;
        }

        System.out.println(ans);
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
