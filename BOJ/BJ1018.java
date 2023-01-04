package com.ssafy.algo.live20230104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1018 {
        static int h = 0, w = 0;
        static char[][] boardW, boardB, board;
        public static void main(String[] args) {
            FastReader sc = new FastReader();
            h = sc.nextInt();
            w = sc.nextInt();

            board = new char[h][w];
            boardW = new char[h][w];
            boardB = new char[h][w];


            for(int i = 0; i < h; i++){
                String str = sc.nextLine();
                for(int j = 0; j < w; j++) {
                    board[i][j] = str.charAt(j);
                }
            }

            boolean flag = false;
            for(int i = 0; i < h * w; i++){
                int r = i / w;
                int c = i % w;
                if(flag){
                    boardW[r][c] = 'W';
                    flag = !flag;
                }
                else {
                    boardW[r][c] = 'B';
                    flag = !flag;
                }
                if(c == w-1 && c % 2 != 0) flag = !flag;
            }

            flag = false;
            for(int i = 0; i < h * w; i++){
                int r = i / w;
                int c = i % w;
                if(flag){
                    boardB[r][c] = 'B';
                    flag = !flag;
                }
                else {
                    boardB[r][c] = 'W';
                    flag = !flag;
                }
                if(c == w-1 && c % 2 != 0) flag = !flag;
            }

//            for(int i = 0; i < h; i++) System.out.println(Arrays.toString(boardW[i]));
//            System.out.println();
//            for(int i = 0; i < h; i++) System.out.println(Arrays.toString(boardB[i]));

            int resW = Integer.MAX_VALUE, resB = Integer.MAX_VALUE;
            for(int z = 0; z <= h - 8; z++) {
                for(int p = 0; p <= w - 8; p++) {
                    int cntW = 0, cntB = 0;
                    for (int i = 0 + z; i < 8 + z; i++) {
                        for (int j = 0 + p; j < 8 + p; j++) {
//                            System.out.print(board[i][j] + " ");
                            if (boardW[i][j] != board[i][j]) {
                                cntW++;
                            }
                            if (boardB[i][j] != board[i][j]) {
                                cntB++;
                            }
                        }
//                        System.out.println();
                    }
//                    System.out.println();
                    resW = Math.min(resW, cntW);
                    resB = Math.min(resB, cntB);
                }
            }

            System.out.println(Math.min(resW, resB));
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
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }

                return st.nextToken();
            }

            int nextInt(){
                return Integer.parseInt(next());
            }

            String nextLine() {
                String str = null;
                try {
                    str = br.readLine();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return str;
            }
    }
}
