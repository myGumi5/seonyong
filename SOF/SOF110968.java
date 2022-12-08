package com.ssafy.algo.live20221208;

import java.util.*;
import java.io.*;


public class SOF110968
{
    public static void main(String args[])
    {
        FastReader sc = new FastReader();

        String str = sc.nextLine();
        String key = sc.nextLine();

        int [] al = new int[26];
        char [][] map = new char[5][5];
        int cnt = 0;
        // System.out.println(key.length());
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(cnt >= key.length() || al[key.charAt(cnt) - 65] == 1){
                    if(cnt < key.length()) {
                         cnt++;
                         j--;
                         continue;
                    }
                    for(int z = 0; z < 26; z++){
                        if(z == 9) continue;
                        if(al[z] == 0){
                            map[i][j] = (char)(z + 65);
                            al[z] = 1;
                            break;
                        }
                    }
                    continue;
                }
                map[i][j] = key.charAt(cnt++);
                al[map[i][j] - 65] = 1;
            }
        }
        
        // for(int i = 0; i < 5; i++)
        //     System.out.println(Arrays.toString(map[i]));

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            if(i == str.length()-1){
                list.add(str.charAt(i)+"X");
            } else if(str.charAt(i) != str.charAt(i+1)){
                list.add(str.substring(i, i+2));
                i++;
            } else{
                if(str.charAt(i) == 'X') list.add(str.charAt(i)+"Q");
                else list.add(str.charAt(i)+"X");
            }

        }
        // System.out.println(list);
        ArrayList<String> newlist = new ArrayList<>();
        for(String sub : list){
            int pt = 0;
            int [] arr = new int[4];
            for(int q = 0; q < sub.length(); q++){
                boolean flag = false;
                for(int r = 0; r < 5; r++){
                    if(flag) break;
                    for(int c = 0; c < 5; c++){
                        if(flag) break;
                        if(map[r][c] == sub.charAt(q)){
                            arr[0+pt] = r;
                            arr[1+pt] = c;
                            pt += 2;
                            flag = true;
                        }
                    }
                }
            }
            int r1 = arr[0], r2 = arr[2], c1 = arr[1], c2 = arr[3];
            // System.out.println(Arrays.toString(arr));
            StringBuilder sb = new StringBuilder();
            if(r1 == r2){
                char ch1 = map[r1][(c1+1) % 5];
                char ch2 = map[r2][(c2+1) % 5];
                sb.append(ch1).append(ch2);
                newlist.add(sb.toString());
            } else if(arr[1] == arr[3]){
                char ch1 = map[(r1+1) % 5][c1];
                char ch2 = map[(r2+1) % 5][c2];
                sb.append(ch1).append(ch2);
                newlist.add(sb.toString());
            } else{
                char ch1 = map[r1][c2];
                char ch2 = map[r2][c1];
                sb.append(ch1).append(ch2);
                newlist.add(sb.toString());
            }
        }

        for(String ans : newlist)
            System.out.print(ans);
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
    }
}