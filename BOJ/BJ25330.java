package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ25330 {
    static int N, K, max = Integer.MIN_VALUE;
    static HashMap<Integer, ArrayList<Integer>> graph;
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] visited;
    static int [] monsters, person;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        K = sc.nextInt();

        monsters = new int[N+1];
        person = new int[N+1];
        graph = new HashMap<>();
        visited = new boolean[N+1];
        // init graph
        for(int i = 1; i <= N; i++){
            if(graph.get(0) == null){
                graph.put(0, new ArrayList<>(Arrays.asList(i)));
            }else{
                graph.get(0).add(i);
            }

            graph.put(i, new ArrayList<>(Arrays.asList(0)));

        }

        for(int i = 1; i <= N; i++){
            monsters[i] = sc.nextInt();
        }
        for(int i = 1; i <= N; i++){
            person[i] = sc.nextInt();
        }

//        int[][] dp = new int[N+1][K+1];
//        for(int i = 1; i <= N; i++){
//            for(int j = 1; j <= K; j++){
//                if(monsters[i] > j){
//                    dp[i][j] = dp[i-1][j];
//                } else{
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-monsters[i]] + person[i]);
//                }
////                System.out.print(dp[i][j]+" ");
//            }
////            System.out.println();
//        }

//        System.out.println(dp[N][K]);

        dfs(0, 0, 0);
        System.out.println(max);

    }
    static void dfs(int depth, int k, int p){
        max = Math.max(p, max);

        for(int num : graph.get(depth)){
            if(num != 0 && visited[num]) continue;
            int damage = 0;
            list.add(num);
            if(num != 0) {
                for (int i : list) {
                    damage += monsters[i];
                }
            }
            visited[num] = true;
            if (k + damage <= K) {
                dfs(num, k + damage, p + person[num]);
            }
            visited[num] = false;
            list.remove(list.size()-1);
        }

    }
    static void init_go(int[] sub1, int []mon, int damage){
        for(int i = 1; i <= N; i++){
            sub1[i] = damage + mon[i];
        }
    }
    static void init_back(int[] sub1, int[] mon, int damage){
        for(int i = 1; i <= N; i++){
            sub1[i] -= damage;
        }
    }
    static void init1(int[] sub2, int[] per){
        for(int i = 1; i <= N; i++){
            sub2[i] = per[i];
        }
    }

    static class Node{
        int K, P, num;

        public Node(int k, int p, int num) {
            K = k;
            P = p;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "K=" + K +
                    ", P=" + P +
                    ", num=" + num +
                    '}';
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
