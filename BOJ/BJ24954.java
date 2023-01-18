package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ24954 {
    static int res = Integer.MAX_VALUE;
    static int N = 0;
    static  int[] arr1 = null;
    static int [] arr2 = null;
    static int[] visited;
    static ArrayList<int[]>[] list = null;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        N = sc.nextInt();

        arr1 = new int[N+1];
        arr2 = new int[N+1];
        list = new ArrayList[N+1];
        visited = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr1[i] = sc.nextInt();
            arr2[i] = arr1[i];
            list[i] = new ArrayList<int[]>();
        }

        for(int i = 1; i <= N; i++){
            int num = sc.nextInt();
            for(int j = 0; j < num; j++) {
                list[i].add(new int[]{sc.nextInt(), sc.nextInt()});
            }
        }

//        for(int i = 1; i <= N; i++ ) {
//            for(int j = 0; j < list[i].size(); j++) {
//                System.out.println(Arrays.toString(list[i].get(j)));
//            }
//        }

        dfs( 1, 0, 0, arr1);


        System.out.println(res);


    }

    static void dfs(int depth, int cnt, int val, int[] arr){
        if(res < val) return;
        if(cnt >= N){
//            System.out.println(val);
            res = Math.min(res, val);
            return;
        }
        if(depth > N) return;

        int[] temp = new int[N+1];
        for(int i = 1; i <= N; i++){
            temp[i] = arr[i];
        }
        if(visited[depth] == 0){
            for (int[] sub : list[depth]) {
                arr1[sub[0]] -= sub[1];
                if (arr1[sub[0]] <= 0) arr1[sub[0]] = 1;
            }
            visited[depth] = 1;
            dfs(1, cnt + 1, val + arr1[depth], arr1);
            visited[depth] = 0;
            for (int[] sub : list[depth]) {
                arr1[sub[0]] = temp[sub[0]];
            }
        }

        dfs(depth + 1, cnt, val, arr1);

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
