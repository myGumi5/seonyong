package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13549 {
    static int[] visited;

    static int N, M;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new int[200001];
        bfs();
    }
    static void bfs(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(N, 1));
        visited[N] = 1;

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.p >= 100001) continue;

            if(n.p == M){
                System.out.println(n.s - 1);
                return;
            }

            if(n.p - 1 >= 0){
                if(visited[n.p - 1] == 0 || visited[n.p - 1] > (n.s + 1)){
                    visited[n.p - 1] = n.s + 1;
                    q.add(new Node(n.p - 1, n.s + 1));
                }
            }
            if(visited[n.p + 1] == 0 || visited[(n.p + 1)] > (n.s + 1)) {
                visited[(n.p + 1)] = n.s + 1;
                q.add(new Node((n.p + 1), n.s + 1));
            }
            if(visited[n.p * 2] == 0 || visited[n.p * 2] > n.s) {
                visited[n.p * 2] = n.s;
                q.add(new Node(n.p * 2, n.s));
            }
        }

//        System.out.println(visited[M] - 1);
    }

    static class Node implements Comparable<Node>{
        int p, s;

        public Node(int p, int s) {
            this.p = p;
            this.s = s;
        }

        public int compareTo(Node o){
            return this.s - o.s;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "p=" + p +
                    ", s=" + s +
                    '}';
        }
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
