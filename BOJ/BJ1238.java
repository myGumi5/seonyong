package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1238 {
    static int N, M, X;
    static int[] dist;
    static HashMap<Integer, ArrayList<Edge>>graph;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();

        dist = new int[N+1];
        graph = new HashMap<>();
        for(int i = 0; i < M; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int num3 = sc.nextInt();

            if(graph.get(num1) == null){
                graph.put(num1, new ArrayList<>(Arrays.asList(new Edge(num2, num3))));
            } else{
                graph.get(num1).add(new Edge(num2, num3));
            }
        }

        for(int i = 1; i <= N; i++) {
            dfs(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            if(i == X) continue;
            max = Math.max(max, dist[i]);
        }

        System.out.println(max);
//        System.out.println(graph);
    }
    static void dfs(int start){
        int[] mst = new int[N+1];
        Arrays.fill(mst, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(Edge e : graph.get(start)){
//            System.out.println(e);
            pq.add(new Edge(e.num, e.weight));
            mst[e.num] = e.weight;
        }

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(graph.get(e.num) == null) continue;
            for(Edge next : graph.get(e.num)){
                if(mst[next.num] <= next.weight + e.weight) continue;

                mst[next.num] = next.weight + e.weight;
                pq.add(new Edge(next.num, next.weight + e.weight));
            }
        }
        if(start == X){
            for(int i = 1; i <= N; i++){
                if(i == X) continue;
                dist[i] += mst[i];
            }
        } else{
            dist[start] += mst[X];
        }
    }

    static class Edge implements Comparable<Edge> {
        int num, weight;

        public Edge(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o1) {
            return this.weight - o1.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "num=" + num +
                    ", weight=" + weight +
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
