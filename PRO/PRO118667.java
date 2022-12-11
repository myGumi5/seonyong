package com.ssafy.algo.live20221211;

import java.util.*;

public class PRO118667 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
	}
	
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
            
        long sum1 = 0, sum2 = 0;
        
        Queue<Long> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        
        for(int i = 0; i < queue1.length; i++){
            sum1 += queue1[i];
            q1.add((long)queue1[i]);
        }
        
        for(int i = 0; i < queue2.length; i++){
            sum2 += queue2[i];
            q2.add((long)queue2[i]);
        }
        
        int cnt = 0;
        while(sum1 != sum2){
            long num = 0;
            if(sum1 > sum2){
                num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            } else{
                num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
            } 
            cnt++;
            answer = cnt;
            if(cnt >= (queue1.length + queue2.length) * 2){
                answer = -1;
                break;
            }
        }

        return answer;
    }
}