package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2847 {
    public static void main(String[] args) {
        // N개의 레벨
        // 5 3 7 5
        // 5 3 5 5 -- 2
        // 2 3 4 5 -- 4

        FastReader sc = new FastReader();
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N;i++){
            arr[i] = sc.nextInt();
        }

        int total = 0;
        for(int i = N-2; i >= 0; i--){
            if(arr[i+1] < arr[i]){
                total += (arr[i] - arr[i+1]) + 1;
                arr[i] = arr[i+1] - 1;
            } else if(arr[i+1] == arr[i]){
                arr[i]--;
                total++;
            }
        }

        System.out.println(total);

    }

    static class FastReader{
        BufferedReader br = null;
        StringTokenizer st = null;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }


        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch(Exception e){
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
