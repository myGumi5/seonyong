package com.example.demo;
import java.util.*;
import java.io.*;
public class PRO150370 {
    class Solution {

        static Map<String, Integer> map;


        static public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
            ArrayList<Integer> list = new ArrayList<>();
            map = new HashMap<>();
            // 2021.12.08", ["A 18"], ["2020.06.08 A"]

            StringTokenizer sub = new StringTokenizer(today, ".");

            int toY = Integer.parseInt(sub.nextToken());
            int toM = Integer.parseInt(sub.nextToken());
            int toD = Integer.parseInt(sub.nextToken());

            // 1 ~ n
            for(int i = 0; i < terms.length; i++){
                StringTokenizer st = new StringTokenizer(terms[i]);

                map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            }

            for(int i = 0; i < privacies.length; i++){
                StringTokenizer st = new StringTokenizer(privacies[i]);

                String date = st.nextToken();
                String privacie = st.nextToken();

                int month = map.get(privacie);
                // System.out.println(month);

                StringTokenizer a = new StringTokenizer(date, ".");

                int nowY = Integer.parseInt(a.nextToken());
                int nowM = Integer.parseInt(a.nextToken());
                int nowD = Integer.parseInt(a.nextToken());

                nowM += month;

                while(nowM > 12){
                    nowY++;
                    nowM = nowM - 12;
                }

                // System.out.println(nowY+" "+nowM +" "+nowD);

                if(toY > nowY){
                    list.add(i+1);
                } else if(toY == nowY){
                    if(toM > nowM){
                        list.add(i+1);
                    } else if(toM == nowM){
                        if(toD >= nowD){
                            list.add(i+1);
                        }
                    }
                }

            }

            return list;
        }
    }
}
