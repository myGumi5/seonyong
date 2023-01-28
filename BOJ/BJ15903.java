package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ15903 {
    public static void main(String[] args) {
        // Priority Queue 4 2 3 1
        // 1 + 2 = 3
        // 4 3 3 3
        // 3 + 3 = 6
        // 4 3 6 6 = 19
        FastReader sc = new FastReader();
        int N = sc.nextInt();
        int M = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            pq.add(sc.nextLong());
        }

        for(int i = 0; i < M; i++){
            long n1 = pq.poll();
            long n2 = pq.poll();

            long sum = n1 + n2;
            pq.add(sum);
            pq.add(sum);
        }

        long res = 0;
        while(!pq.isEmpty()) {
            res += pq.poll();
        }

        System.out.println(res);

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

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}
