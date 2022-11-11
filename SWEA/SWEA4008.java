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
			// ������ max, min �� �ʱ�ȭ
			
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
			// ������ ù ���� ���� ���� ���Ǵ� ���̹Ƿ�
			// �ʱ� depth�� 1, ���Ǿ���ϴ� ���� numbers�� ù ������ �����Ѵ�.
			
			System.out.println("#"+t+" "+Math.abs(max - min));
		}
		
	}
	private static void init() {
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}
	
	static void dfs(int depth, int cnt) {
		// ���� ���� : ���������� ������ �������� �����Ѵ�.
		// depth�� N�̸� ���������� ���Ѱ��̴�.
		if(depth == N) {
			if(max < cnt) max = cnt;
			if(min > cnt) min = cnt;
			// �ִ񰪰� �ּڰ��� ���Ѵ�.
			
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			// ����� �� �ִ� ��ȣ�� ������ �����Ǿ� �ִ�.
			// ��ȣ�� �� ����Ͽ��ٸ�, ���̻� ����� �� �����Ƿ� �� �迭�� ��Ұ� 0���� Ŀ��
			// ���� ������ �����Ѵ�.
			if(symbols[i] > 0) {
				
				// '/' ������ ������ ��, ����ϴ� ���� ���� 0�̸�, ������ �߻��ϹǷ�
				// ���ܸ� ó�����ش�.
				if(i == 3 && numbers[depth] == 0) continue;
				
				// �����ڸ� �����Ͽ����Ƿ� �����ڸ� 1�� ���ش�.
				symbols[i]--;
				
				// dfs ������ ����Ͽ� ����/������ ���Ѵ�.
				dfs(depth+1, cal(cnt, i, depth));
				
				// �����ڸ� �����ؼ� ���� ������ �������Ƿ� ������ ������ ������� �������´�.
				symbols[i]++;
				
			}
		}
		
	}
	
	private static int cal(int cnt, int i, int depth) {
		// i ��
		// 0�϶�, +
		// 1�϶�, -
		// 2�϶�, *
		// 3�϶�, /
		// ������ �����Ѵ�.
		
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
