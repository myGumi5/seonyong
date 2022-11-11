package com.ssafy.algo.live20221111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4008 {
	static int T, N, max, min;
	static int[] symbols, numbers;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			init();
			// 시작전 max, min 값 초기화
			
			symbols = new int[4];
			for(int i = 0; i < 4; i++) {
				symbols[i] = sc.nextInt();
			}
			numbers = new int[N];
			for(int i = 0; i < N; i++) {
				numbers[i] = sc.nextInt();
			}
			// input process
			
			dfs(1, numbers[0]);
			// 숫자의 첫 값에 다음 값이 계산되는 것이므로
			// 초기 depth는 1, 계산되어야하는 값은 numbers의 첫 값으로 설정한다.
			
			System.out.println("#"+t+" "+Math.abs(max - min));
		}
		
	}
	private static void init() {
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}
	
	static void dfs(int depth, int cnt) {
		// 종료 조건 : 마지막까지 연산을 끝냈으면 종료한다.
		// depth가 N이면 마지막까지 더한것이다.
		if(depth == N) {
			if(max < cnt) max = cnt;
			if(min > cnt) min = cnt;
			// 최댓값과 최솟값을 구한다.
			
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			// 사용할 수 있는 기호의 갯수가 한정되어 있다.
			// 기호를 다 사용하였다면, 더이상 사용할 수 없으므로 각 배열의 요소가 0보다 커야
			// 다음 연산을 진행한다.
			if(symbols[i] > 0) {
				
				// '/' 연신을 진행할 때, 계산하는 다음 값이 0이면, 에러가 발생하므로
				// 예외를 처리해준다.
				if(i == 3 && numbers[depth] == 0) continue;
				
				// 연산자를 선택하였으므로 연산자를 1개 빼준다.
				symbols[i]--;
				
				// dfs 로직을 사용하여 순열/조합을 구한다.
				dfs(depth+1, cal(cnt, i, depth));
				
				// 연산자를 선택해서 계산된 로직이 끝났으므로 연산자 갯수를 원래대로 돌려놓는다.
				symbols[i]++;
				
			}
		}
		
	}
	
	private static int cal(int cnt, int i, int depth) {
		// i 가
		// 0일때, +
		// 1일때, -
		// 2일때, *
		// 3일때, /
		// 연산을 진행한다.
		
		if(i == 0) {
			return cnt + numbers[depth];
		} else if(i == 1) {
			return cnt - numbers[depth];
		}else if(i == 2) {
			return cnt * numbers[depth];
		} else {
			return cnt / numbers[depth];
		}
	}

	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
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
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
