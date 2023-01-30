package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1253 {
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        N = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(twoPointer(i)){
//                System.out.println(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    static boolean twoPointer(int i){
        int left = 0;
        int right = N-1;

        while(left < right){
            if(i == left) left++;
            else if (i == right) right--;

            if(left >= right){
                break;
            }

            int temp = arr[left] + arr[right];

            if(arr[i] < temp){
                right--;
            } else if(arr[i] > temp){
                left++;
            } else{
                return true;
            }

        }


        return false;
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
