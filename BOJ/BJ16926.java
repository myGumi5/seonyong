import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16926 {
	static int N, M, R, minX = 0, minY = 0, maxX = 0, maxY = 0;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		input();
		
		for(int r = 0; r < R; r++) {
			maxY = N;
			maxX = M;
			minX = 0;
			minY = 0;
			
			int i = 0;
			while(true) {
				if(minX >= M / 2|| minY >= N / 2)
					break;
				rollingMap(0 + i, 0 + i);
				minX++;
				minY++;
				maxX--;
				maxY--;
				i++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	static void rollingMap(int i, int j) {
		int temp = map[i][j];
		int grade = 0;
		
		int y = i;
		int x = j;
		while(true) {	
			y = y + dy[grade];
			x = x + dx[grade];
			
			if(x < minX || x >= maxX || y < minY || y >= maxY) {
				x -= dx[grade];
				y -= dy[grade];
				grade++;
				continue;
			}
			
			map[y-dy[grade]][x-dx[grade]] = map[y][x];
			if(x == i && y == j) {
				map[i+1][j] = temp;
				break;
			}
			
		}
	
	}
	
	static void input() {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		FastReader(){
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
		
		int nextInt() {
			return Integer.parseInt(next());
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
		
	}
}
/*
 6 4 1
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28
25 26 27 28

*/
