package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2609 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int a = sc.nextInt();

        int max =  0;
        int m = Math.max(n, a);
        int len = Math.min(n, a);
        for(int i = 1; i <= len; i++){
            if(n % i == 0 && a % i == 0){
                max = i;
            }
        }

        int nC = 2;
        int [] arr = new int[m+1];
        while(n > 1){
            if(n % nC != 0){
                nC++;
                continue;
            }
             n /= nC;
            arr[nC]++;
        }
        int aC = 2;
        int [] arr1 = new int[m+1];
        while(a > 1){
            if(a % aC != 0){
                aC++;
                continue;
            }
            a /= aC;
            arr1[aC]++;
        }


        int total = 1;
        for(int i = 0; i <= m; i++){
            if(arr[i] != 0 && arr1[i] != 0){
                total *= Math.pow(i, Math.max(arr[i], arr1[i]));
            } else{
                total *= Math.pow(i, arr1[i]);
                total *= Math.pow(i, arr[i]);
            }
        }

        System.out.println(max);
        System.out.println(total);

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
