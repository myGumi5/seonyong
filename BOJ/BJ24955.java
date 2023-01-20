package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ24955 {
    static int N, Q, start, end;
    static HashMap<Integer, ArrayList<Integer>> map;
    static  long[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        N = sc.nextInt();
        Q = sc.nextInt();

        arr = new long[N+1];
        map = new HashMap<>();
        for(int i = 0; i < N; i++){
            arr[i+1] = sc.nextInt();
        }

        for(int i = 0; i < N - 1; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            if(map.get(num1) == null){
                map.put(num1, new ArrayList<>(Arrays.asList(num2)));
            } else{
                map.get(num1).add(num2);
            }

            if(map.get(num2) == null){
                map.put(num2, new ArrayList<>(Arrays.asList(num1)));
            } else{
                map.get(num2).add(num1);
            }
        }

//        System.out.println(Long.parseLong("00000000010000000"));
                                            //922 337 203 685 477 5807

        for(int i = 0; i < Q; i++){
            visited = new boolean[N+1];
            start = sc.nextInt();
            end = sc.nextInt();

            bfs();
        }
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, arr[start]));
        visited[start] = true;

        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.number == end){
                System.out.println(n.val);
                return;
            }

            if(map.get(n.number) == null) continue;
            for(int num : map.get(n.number)){
                if(visited[num]) continue;
                visited[num] = true;

                long ans = n.val;
                for(long i = 1; i <= arr[num]; i *= 10){
                    ans = (ans * 10) % 1000000007;
                }

                ans += arr[num];
                ans %= 1000000007;
                q.add(new Node(num, ans));
            }

        }
    }

    static class Node{
        int number;
        long val;

        public Node(int number, long val) {
            this.number = number;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", val='" + val + '\'' +
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
    }
}
