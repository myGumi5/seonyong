package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2108 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        double sum = 0;
        int[] arr = new int[8002];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(num);
            sum += num;
            if(num < 0){
                num = num * -1;
            } else{
                num += 4001;
            }
            arr[num]++;
        }
        // 최댓값 찾고
        int max = 0;
        int number = 0;
        for(int i = 4000; i > 0; i--){
            if(max < arr[i]){
                max = arr[i];
                number = i;
            }
        }
        for(int i = 4001; i < 8002; i++){
            if(max < arr[i]){
                max = arr[i];
                number = i;
            }
        }
        // 최댓값 갯수 구하구
        int cnt = 0;
        for(int i = 0; i < 8001; i++){
            if(arr[i] == max){
                cnt++;
            }
        }

        // 최대값 갯수에 2번째 최빈값 구하기
        int c = 0;
        if(cnt > 1){
            for(int i = 4000; i > 0; i--){
                if(c == 2){
                    break;
                }
                if(arr[i] == max){
                    number = i;
                    c++;
                }
            }
            for(int i = 4001; i < 8002; i++){
                if(c == 2){
                    break;
                }
                if(arr[i] == max){
                    number = i;
                    c++;
                }
            }
        }

        Collections.sort(list);
        System.out.println(Math.round(sum / n));
        System.out.println(list.get(n / 2));
        Arrays.sort(arr);
        if(number >= 4000){
            System.out.println(number - 4001);
        } else{
            System.out.println(number * -1);
        }
        System.out.println(Math.abs(list.get(0) - list.get(n - 1)));
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
