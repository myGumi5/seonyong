package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1911 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int N = sc.nextInt();
        int L = sc.nextInt();


        List<Node> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(new Node(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);

        int cnt = 0;
        for(int i = 0; i < N; i++){
            Node n = list.get(i);
            int start = n.start;
            int end = n.end;

            int res = (end - start) / L;
            if((end - start) % L > 0){
                res++;
                cnt += res;
            } else{
                cnt += res;
            }

            if(i == N - 1) break;
            if(list.get(i+1).start <= (res * L) + start){
                list.get(i+1).start = (res * L) + start;
            }
        }

        System.out.println(cnt);

    }
    static class Node implements Comparable<Node>{
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
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
