package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2785 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int N = sc.nextInt();

        ArrayList<Integer> q = new ArrayList<>();
        for(int i = 0; i < N; i++){
            q.add(sc.nextInt());
        }

        Collections.sort(q);

        int cnt = 0;
        int len = q.size();
        for(int i = 0; i < N; i++){
            if(len - 1 == q.get(i)){
                cnt += q.get(i);
                break;
            } else if(len - 1 > q.get(i)){
                len -= q.get(i) + 1;
                cnt += q.get(i);
            } else{
                cnt += len - 1;
                break;
            }
        }

        System.out.println(cnt);

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
