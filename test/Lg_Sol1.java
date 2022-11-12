package com.ssafy.coding.live20221112;

import java.util.ArrayList;
import java.util.Arrays;

public class Lg_Sol1 {

	static class Solution{
		static ArrayList<Integer> answer = new ArrayList<>();
		static ArrayList<Integer> list;
		static int[] marbles;
		static boolean[] visited;
		static int maxM, maxLen, maxSum;
		
		
		
		public ArrayList<Integer> solution(int[] marbles) {
			
			
			list = new ArrayList<>();
			
			Solution.marbles = marbles;
			
			visited = new boolean[marbles.length];		
			
			maxM = Integer.MAX_VALUE;
			maxLen = Integer.MIN_VALUE;
			maxSum = Integer.MIN_VALUE;
			
			dfs(0);
			
			return answer;
		}
		
		static void dfs(int depth) {
			if(list.size() >= 1) {
				for(int cen = 0; cen < (1 + (list.size() - 1) * 2); cen++) {
//					if(list.size() == 4 && list.get(0) == 3 && list.get(1) == 9 &&
//							list.get(2) == 5 && list.get(3) == 7) {
//						System.out.println("start");
//					}
					
					if(list.size() != 1) {
						// 양쪽 무게 같다면 진행
						if(checkSide(cen)) continue;
					}
					
					if(getCount(cen) <= maxM) {
						if(getCount(cen) == maxM) {
							if (list.size() >= maxLen) {
								if (list.size() == maxLen) {
									if (getSum() >= maxSum) {
										if (getSum() == maxSum) {
											// 사전 순으로 비교
											if (dictionary()) {
												answer = new ArrayList<>(list);
											}

										} else {
											
												maxSum = getSum();
												answer = new ArrayList<>(list);
											
										}
									}
								} else {
									
										maxLen = list.size();
										maxSum = getSum();
										answer = new ArrayList<>(list);
									
								}
							}
						} else {
								maxM = getCount(cen);
								maxLen = list.size();
								maxSum = getSum();
								answer = new ArrayList<>(list);
						}
					}
				}
			}
			if(depth == marbles.length) return;
			
			if(!visited[depth]) {
				list.add(marbles[depth]);
				visited[depth] = true;
				dfs(0);
				list.remove(list.size()-1);
				visited[depth] = false;
			}
			
			dfs(depth+1);
			
		}

		private static int getCount(int cen) {
			int left = 0;
			int right = 0;
			
			// cen이 짝수면, 구슬 바로 아래 있고
			// cen이 홀수면, 구슬과 구슬 사이에 있다는 뜻
			if(cen % 2 == 0) {
				// 좌측 값
				for(int i = 0; i < cen/2; i++) {
					left++;
				}
				// 우측 값 
				for(int i = cen/2+1; i < list.size(); i++) {
					right++;
				}
			} else {
				// 좌측 값
				for(int i = 0; i <= cen/2; i++) {
					left++;
				}
				// 우측 값 
				for(int i = cen/2+1; i < list.size(); i++) {
					right++;
				}
			}
			return Math.abs(left - right);
		}

		private static boolean dictionary() {
			
			if(answer.toString().compareTo(list.toString()) > 0) return true;
			
			return false;
		}

		private static int getSum() {
			int sum = 0;
			for(int i = 0; i < list.size(); i++) {
				sum += list.get(i);
			}
			return sum;
		}

		private static boolean checkSide(int cen) {
			int left = 0;
			int right = 0;
			
			// cen이 짝수면, 구슬 바로 아래 있고
			// cen이 홀수면, 구슬과 구슬 사이에 있다는 뜻
			if(cen % 2 == 0) {
				// 좌측 값
				for(int i = 0; i < cen/2; i++) {
					left += list.get(i);
				}
				// 우측 값 
				for(int i = cen/2+1; i < list.size(); i++) {
					right += list.get(i);
				}
			} else {
				// 좌측 값
				for(int i = 0; i <= cen/2; i++) {
					left += list.get(i);
				}
				// 우측 값 
				for(int i = cen/2+1; i < list.size(); i++) {
					right += list.get(i);
				}
			}
			
			if(left == right) return false;
			
			return true;
		}
		
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] marbles = {5, 5, 1, 4};
		System.out.println(s.solution(marbles));
		
		
	}

	
}
