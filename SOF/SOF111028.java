package com.ssafy.algo.live20221209;
import java.util.*;
import java.io.*;


public class SOF111028
{   
    static int H, W, sD = 0, sR = 0, sC = 0, ansD = 0, ansR = 0, ansC = 0;
    static char[][] map;
    static boolean[][] visited;
    
    static StringBuilder ans;
    static ArrayList<String> list;
    static ArrayList<int[]> road;
                    // µ¿ ³²  ¼­  ºÏ
    static int[] dy = {0, 1,  0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        H = sc.nextInt();
        W = sc.nextInt();

        map = new char[H+1][W+1];
        road = new ArrayList<>();
        list = new ArrayList<>();
        ans = new StringBuilder();
        for(int i = 1; i <= H; i++){
            String str = sc.nextLine();
            for(int j = 1; j <= W; j++){
                map[i][j] = str.charAt(j-1);
                if(map[i][j] == '#'){
                    road.add(new int[]{i, j});
                }
            }
        }

   
        for(int [] arr : road){
            for(int d = 0; d < 4; d++ ){
                visited = new boolean[H+1][W+1];
                visited[arr[0]][arr[1]] = true;
                sR = arr[0];
                sC = arr[1];
                sD = d;
                dfs(arr[0], arr[1], d, 1);
            }
        }

        System.out.println(ansR + " " + ansC);
        char ch = 'X';
        if(ansD == 0){
            ch = '>';
        } else if(ansD == 1) {
            ch = 'v';
        } else if(ansD == 2) {
            ch = '<';
        } else if(ansD == 3) {
            ch = '^';
        }
        System.out.println(ch);
        System.out.print(ans.toString());
        

    }
    static void dfs(int r, int c, int dir, int cnt){
        if(cnt == road.size()){
//            System.out.print("in");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < list.size(); i++){
                sb.append(list.get(i));
            }
            if(sb.length() < ans.length() || ans.length() == 0){
                ans = sb;
                ansR = sR;
                ansC = sC;
                ansD = sD;
            }
            return;
        }

        for(int d = 0; d < 4; d++){
            int nd = (dir + d) % 4;
            String str = "A";
            if(d == 1){
                str = "RA";
            } else if(d == 2){
                str = "LLA";
            } else if(d == 3){
                str = "LA";
            }
            int nr1 = r + dy[nd], nc1 = c + dx[nd], nr2 = r + dy[nd] * 2, nc2 = c + dx[nd] * 2;
            if(nr2 < 1 || nc2 < 1 || nr2 > H || nc2 > W) continue;
            if(map[nr1][nc1] == '.' || map[nr2][nc2] == '.' || visited[nr1][nc1] || visited[nr2][nc2]) continue;
            
            list.add(str);
            visited[nr1][nc1] = true;
            visited[nr2][nc2] = true;
            dfs(nr2, nc2, nd, cnt+2);
            list.remove(list.size() - 1);
            visited[nr1][nc1] = false;
            visited[nr2][nc2] = false;
        }

    }

/*
 A RA LA RA LA RA A RA A A A RA RA LA LA A LA RA RA A RA A
 A RA LA RA LA RA A RA A A A RA RA LA LA A LA RA RA A RA A
 */
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
                } catch(Exception e){

                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = null;
            try{
                str = br.readLine();
            } catch(Exception e){

            }
            return str;
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}