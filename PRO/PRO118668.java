package com.ssafy.algo.live20221213;

import java.util.*;
import java.io.*;

public class PRO118668 {

	public static void main(String[] args) {
		solution(10, 10, new int[][]{{10,15,2,1,2},{20,20,3,3,4}});
//		solution(0, 0, new int[][] {{0,0,0,0,2},{10,10,3,1,2},{10,10,4,0,2},{10,10,0,4,2}});
	}
	
	public static int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        int goal_alp = 0;
        int goal_cop = 0;
        for(int i = 0; i < problems.length; i++){
            if(goal_alp < problems[i][0]){
                goal_alp = problems[i][0];
            }
            if(goal_cop < problems[i][1]){
                goal_cop = problems[i][1];
            }
        }
        
        int [][] dp = new int[goal_alp+2][goal_cop+2];
        for(int i = 0; i <= goal_alp+1; i++) {
        	Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        
        dp[alp][cop]=0;
        
        for(int i = alp; i <= goal_alp; i++ ) {
        	for(int j = cop; j <= goal_cop; j++) {
        		dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
        		dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
        		
        		for(int z = 0; z < problems.length; z++) {
        			int[] arr = problems[z];
        			
        			if(i >= arr[0] && j >= arr[1]) {
        				if(i+arr[2] > goal_alp && j+arr[3] > goal_cop) {
        					dp[goal_alp][goal_cop] = Math.min(dp[goal_alp][goal_cop], dp[i][j] + arr[4]);
        				} else if(i + arr[2] > goal_alp) {
        					dp[goal_alp][j + arr[3]] = Math.min(dp[goal_alp][j+arr[3]], dp[i][j] + arr[4]);
        				} else if(j + arr[3] > goal_cop) {
        					dp[i+arr[2]][goal_cop] = Math.min(dp[i+arr[2]][goal_cop], dp[i][j] + arr[4]);
        				} else if(i + arr[2] <= goal_alp && j + arr[3] <= goal_cop){
        					dp[i+arr[2]][j + arr[3]] = Math.min(dp[i+arr[2]][j + arr[3]], dp[i][j] + arr[4]);
        				}
        			}
        		}
        	}
        }
        
        
        
        return dp[goal_alp][goal_cop];
    }
	
	
/* 완전탐색, 시간초과
	static int len, answer;
	static int[][] solutions;
    static int goal_alp, goal_cop;
	
	public static int solution(int alp, int cop, int[][] problems) {
			answer = Integer.MAX_VALUE;
	        len = problems.length;
	        solutions = problems;

	        goal_alp = 0;
            goal_cop = 0;
            for(int i = 0; i < len; i++){
                if(goal_alp < problems[i][0]){
                    goal_alp = problems[i][0];
                }
                if(goal_cop < problems[i][1]){
                    goal_cop = problems[i][1];
                }
            }
        
	        dfs(alp, cop, 0);
	        
	        System.out.println(answer);
	        
	        return answer;
	}
	 
	 static void dfs(int alp, int cop, int res) {
		 if(alp >= goal_alp && cop >= goal_cop) {
			 answer = Math.min(answer, res);
			 return;
		 }
		 if(res >= answer) return;
		 
		 if(alp < goal_alp) dfs(alp + 1, cop, res + 1);
		 if(cop < goal_cop) dfs(alp, cop + 1, res + 1);
		 
		 for(int i = 0; i < len; i++) {
			 if(solutions[i][0] <= alp && solutions[i][1] <= cop) {
				 dfs(alp + solutions[i][2], cop + solutions[i][3], res + solutions[i][4]);
			 }
		 }
		 

	 }
	 */
}
