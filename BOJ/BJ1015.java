package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1015 {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int num = sc.nextInt();

        int[] number = new int[1001];
        int[] A = new int[num];
        for(int i = 0; i < num; i++){
            A[i] = sc.nextInt();
            number[A[i]]++;
        }

        int[] P = new int[num];
        for(int i = num-1; i >= 0; i--){
            int cnt = 0;

            for(int j = 0; j < num; j++){
                if(i == j) continue;
                if(A[i] > A[j]) cnt++;
            }

            P[i] = cnt + (number[A[i]]-- - 1);
        }

        for(int i = 0; i < num; i++){
            System.out.print(P[i] + " ");
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
