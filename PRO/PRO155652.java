package com.example.demo;

public class PRO155652 {

    public static void main(String[] args) {

        System.out.println(solution("z",   "abcdefghij", 20));
    }
    static String solution(String s, String skip, int index) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            int cnt = 0;
            int n = 1;
            while(cnt < index){
                if(c + n > 'z'){
                    c = 'a';
                    n = 0;
                }
                if(!skip.contains(Character.toString(c+n))){
                    cnt++;
                }
                n++;
            }

            sb.append(Character.toString(c + n-1));
        }



        return sb.toString();
    }
}
