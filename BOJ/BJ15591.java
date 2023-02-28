package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15591 {
    static int Q, N;
    static int[][] values;
    static HashMap<Integer, ArrayList<Integer>> map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        Q = sc.nextInt();

        map = new HashMap<>();
        values = new int[N+1][N+1];

        for(int i = 0; i < N-1; i++){
            int n = sc.nextInt();
            int r = sc.nextInt();
            int v = sc.nextInt();

            values[n][r] = v;
            values[r][n] = v;

            if(map.get(n) == null){
                map.put(n, new ArrayList<>(Arrays.asList(r)));
            } else{
                map.get(n).add(r);
            }

            if(map.get(r) == null){
                map.put(r, new ArrayList<>(Arrays.asList(n)));
            } else{
                map.get(r).add(n);
            }
        }

        for(int i = 0; i < Q; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();

            bfs(k, n);

        }

        System.out.println(sb.toString());
    }
    static void bfs(int k, int n){
        boolean[] visited = new boolean[N+1];

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(n);
        visited[n] = true;


        int cnt = 0;
        while(!q.isEmpty()){
            int N = q.poll();

            if(map.get(N) == null) continue;
            for(int num : map.get(N)){
                if(visited[num]) continue;
                if(k <= values[N][num]){
                    cnt++;
                    q.add(num);
                    visited[num] = true;
                }
            }

        }
        sb.append(cnt).append("\n");
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
