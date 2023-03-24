package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1967 {
    static int n, res = 0, nd;
    static boolean[] visited;
    static Map<Integer, ArrayList<Node>> map;
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        n = sc.nextInt();

        map = new HashMap<>();
        for(int i = 0; i < n-1; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            int val = sc.nextInt();

            if(map.get(r) == null){
                map.put(r, new ArrayList<>(Arrays.asList(new Node(c, val))));
            } else{
                map.get(r).add(new Node(c, val));
            }

            if(map.get(c) == null){
                map.put(c, new ArrayList<>(Arrays.asList(new Node(r, val))));
            } else{
                map.get(c).add(new Node(r, val));
            }
        }

//        System.out.println(map);

        visited = new boolean[n+1];
        dfs(1, 0);


        visited = new boolean[n+1];
        dfs(nd, 0);

        System.out.println(res);

    }

    static void dfs(int node, int len){
        if(len > res){
            res = len;
            nd = node;
        }

        visited[node] = true;

        if(map.get(node) == null) return;
        for(Node n : map.get(node)){
            if(visited[n.num]) continue;
            dfs(n.num, len + n.val);
        }
    }

    static class Node implements Comparable<Node>{
        int num, val;

        @Override
        public int compareTo(Node o) {
            return o.val - this.val;
        }

        public Node(int num, int val) {
            this.num = num;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", val=" + val +
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
            while(st == null || !st.hasMoreElements()){
                try{
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

