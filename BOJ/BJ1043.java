package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1043 {
    static int N, M, max = 0;
    static ArrayList<Integer> not_trues, trues;
    static ArrayList<Integer>[] parties;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        M = sc.nextInt();

        parties = new ArrayList[M];
        not_trues = new ArrayList<>();
        trues = new ArrayList<>();

        int c = sc.nextInt();
        for(int i = 0; i < c; i++){
            trues.add(sc.nextInt());
        }

        for(int i = 0; i < M; i++){
            parties[i] = new ArrayList<>();
            int num = sc.nextInt();
            for(int j = 0; j < num; j++){
                parties[i].add(sc.nextInt());
            }
        }

//        for(int i = 0; i < M; i++){
//            System.out.println(parties[i]);
//        }

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int depth, int cnt){
        if(depth >= M){
            max = Math.max(cnt, max);
            return;
        }

        if(checkJoke(depth)){
            add(not_trues, depth);
            dfs(depth+1, cnt+1);
            init(not_trues, depth);
        }

        if(checkNotJoke(depth)){
            add(trues, depth);
            dfs(depth+1, cnt);
            init(trues, depth);
        }
    }

    private static void init(ArrayList<Integer> list, int depth) {
        for(int n : parties[depth]){
            list.remove(list.size()-1);
        }
    }

    private static void add(ArrayList<Integer> list, int depth) {
        for(int n : parties[depth]){
            list.add(n);
        }
    }

    private static boolean checkNotJoke(int depth) {
        for(int n : parties[depth]){
            if(not_trues.contains(n)){
                return false;
            }
        }
        return true;
    }

    private static boolean checkJoke(int depth) {
        for(int n : parties[depth]){
            if(trues.contains(n)){
                return false;
            }
        }

        return true;
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
