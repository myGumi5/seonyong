package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PRO17682 {
    public static void main(String[] args) {
        System.out.println(solution("1S*2T*3S"));
    }
    static public int solution(String dartResult) {
        int answer = 0;


        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < dartResult.length(); i++){
            int j = i - 1;
            int mul = 1;
            int sub = 0;

            if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T'){
                while(j >= 0 && (dartResult.charAt(j) - 48 >= 0 && dartResult.charAt(j) - 48 <= 9)){
                    sub += (dartResult.charAt(j) - 48) * mul;
                    mul *= 10;
                    j--;
                }
                if(dartResult.charAt(i) == 'S') {
                    list.add(sub);
                } else if(dartResult.charAt(i) == 'D'){
                    list.add((int)Math.pow(sub, 2));
                } else if(dartResult.charAt(i) == 'T'){
                    list.add((int)Math.pow(sub, 3));
                }

            } else if(dartResult.charAt(i) == '*' ){
                list.set(list.size() - 1, list.get(list.size() - 1) * 2);
                if(list.size() >= 2) {
                    list.set(list.size() - 2, list.get(list.size() - 2) * 2);
                }
            } else if (dartResult.charAt(i) == '#'){
                list.set(list.size() - 1, list.get(list.size() - 1) * -1);
            }
        }

        for(int i = 0; i < list.size(); i++){
            answer += list.get(i);
        }



        return answer;
    }

}
