package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1543 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        String str = sc.nextLine();
        String sub = sc.nextLine();

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < str.length(); i++){
            int p = 0, right = i, cnt = 0, count = 0;
            while(right < str.length()) {
                if (str.charAt(right) == sub.charAt(p)) {
                    p++;
                    cnt++;
                } else{
                    cnt = 0;
                    p = 0;
                }

                if(cnt == sub.length()){
                    p = 0;
                    cnt = 0;
                    count++;
                }

                right++;
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
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
