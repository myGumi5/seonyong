package com.ssafy.coding.live20220817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15683 {
	static int N, M, cnt = 0, min = Integer.MAX_VALUE;
	static int[][] map, copy;
	static int [] dx1 = {1, 0, -1, 0};
	static int [] dy1 = {0, 1, 0, -1};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
				if(map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3 || map[i][j] == 4 || map[i][j] == 5) cnt++;
			}
		}
		// input process
		
		pro(new int[cnt+1], 1);
		// 중복가능한 순열을 통해 cctv의 방향을 결정한다.
		
		System.out.println(min);
	}
	static void cctv(int i, int j, int num, int dir) {
		if(num == 1) {
			while(true) {
				i += dy1[dir];
				j += dx1[dir];
				
				if(i >= N || i < 0 || j >= M || j < 0) break;
				if(map[i][j] == 6) break;
				
				if(map[i][j] == 0) map[i][j] = 9;
				
			}
		}else if(num == 2) {
			int subI = i;
			int subJ = j;
			boolean check1 = true;
			boolean check2 = true;
			
			while(check1 || check2) {
				
				if(check1) {
					i += dy1[dir];
					j += dx1[dir];
				}
				if(check2) {
					subI -= dy1[dir];
					subJ -= dx1[dir];
				}
				
				if(check1 && (i < N && i >= 0 && j < M && j >= 0)) {
					if(map[i][j] != 6) {
						if(map[i][j] == 0) {
							map[i][j] = 9;
						}
					} else {
						check1 = false;
					}
				} else {
					check1 = false;
				}
	
				if(check2 && (subI < N && subI >= 0 && subJ < M && subJ >= 0)) {
					if(map[subI][subJ] != 6) {
						if(map[subI][subJ] == 0) {
							map[subI][subJ] = 9;
						}
					} else {
						check2 = false;
					}
				} else {
					check2 = false;
				}
				
				
			}
		}else if(num == 3) {
			int subI = i;
			int subJ = j;
			boolean check1 = true;
			boolean check2 = true;
			
			while(check1 || check2) {
				if(check1) {
					i += dy1[dir];
					j += dx1[dir];
				}
				if(check2) {
					subI += dy1[(dir + 1) % 4];
					subJ += dx1[(dir + 1) % 4];
				}
				
				if(check1 && (i < N && i >= 0 && j < M && j >= 0)) {
					if(map[i][j] != 6) {
						if(map[i][j] == 0) {
							map[i][j] = 9;
						}
					} else {
						check1 = false;
					}
				} else {
					check1 = false;
				}
	
				if(check2 && (subI < N && subI >= 0 && subJ < M && subJ >= 0)) {
					if(map[subI][subJ] != 6) {
						if(map[subI][subJ] == 0) {
							map[subI][subJ] = 9;
						}
					} else {
						check2 = false;
					}
				} else {
					check2 = false;
				}
				
				
				
			}
		}else if(num == 4) {
			int subI = i;
			int subJ = j;
			int subI1 = i;
			int subJ1 = j;
			boolean check1 = true;
			boolean check2 = true;
			boolean check3 = true;
			
			while(check1 || check2 || check3) {
				if(check1) {
					i += dy1[dir];
					j += dx1[dir];
				}
				if(check2) {
					subI += dy1[(dir + 1) % 4];
					subJ += dx1[(dir + 1) % 4];
				}
				if(check3) {
					subI1 += dy1[(dir + 2) % 4];
					subJ1 += dx1[(dir + 2) % 4];
				}
				if(check1 && (i < N && i >= 0 && j < M && j >= 0)) {
					if(map[i][j] != 6) {
						if(map[i][j] == 0) {
							map[i][j] = 9;
						}
					} else {
						check1 = false;
					}
				} else {
					check1 = false;
				}
	
				if(check2 && (subI < N && subI >= 0 && subJ < M && subJ >= 0)) {
					if(map[subI][subJ] != 6) {
						if(map[subI][subJ] == 0) {
							map[subI][subJ] = 9;
						}
					} else {
						check2 = false;
					}
				} else {
					check2 = false;
				}
				
				if(check3 && (subI1 < N && subI1 >= 0 && subJ1 < M && subJ1 >= 0)) {
					if(map[subI1][subJ1] != 6) {
						if(map[subI1][subJ1] == 0) {
							map[subI1][subJ1] = 9;
						}
					} else {
						check3 = false;
					}
				} else {
					check3 = false;
				}
				
			}
		}else if(num == 5) {
			int subI = i;
			int subJ = j;
			int subI1 = i;
			int subJ1 = j;
			int subI2 = i;
			int subJ2 = j;
			boolean check1 = true;
			boolean check2 = true;
			boolean check3 = true;
			boolean check4 = true;
			
			while(check1 || check2 || check3 || check4) {
				if(check1) {
					i += dy1[dir];
					j += dx1[dir];
				}
				if(check2) {
					subI += dy1[(dir + 1) % 4];
					subJ += dx1[(dir + 1) % 4];
				}
				if(check3) {
					subI1 += dy1[(dir + 2) % 4];
					subJ1 += dx1[(dir + 2) % 4];
				}
				if(check4) {
					subI2 += dy1[(dir + 3) % 4];
					subJ2 += dx1[(dir + 3) % 4];
				}
				if(check1 && (i < N && i >= 0 && j < M && j >= 0)) {
					if(map[i][j] != 6) {
						if(map[i][j] == 0) {
							map[i][j] = 9;
						}
					} else {
						check1 = false;
					}
				} else {
					check1 = false;
				}
	
				if(check2 && (subI < N && subI >= 0 && subJ < M && subJ >= 0)) {
					if(map[subI][subJ] != 6) {
						if(map[subI][subJ] == 0) {
							map[subI][subJ] = 9;
						}
					} else {
						check2 = false;
					}
				} else {
					check2 = false;
				}
				
				if(check3 && (subI1 < N && subI1 >= 0 && subJ1 < M && subJ1 >= 0)) {
					if(map[subI1][subJ1] != 6) {
						if(map[subI1][subJ1] == 0) {
							map[subI1][subJ1] = 9;
						}
					} else {
						check3 = false;
					}
				} else {
					check3 = false;
				}
				if(check4 && (subI2 < N && subI2 >= 0 && subJ2 < M && subJ2 >= 0)) {
					if(map[subI2][subJ2] != 6) {
						if(map[subI2][subJ2] == 0) {
							map[subI2][subJ2] = 9;
						}
					} else {
						check4 = false;
					}
				} else {
					check4 = false;
				}
			}
		}
	}
	
	static void pro(int arr[], int depth) {
		if(depth == cnt+1) {
			//System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, cnt+1)));
			int num = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3 || map[i][j] == 4 || map[i][j] == 5) {
						cctv(i, j, map[i][j], arr[num++] - 1);
					}
				}
			}
			// 중복가능한 순열을 통해 cctv의 감시영역을 표시한다.
			
			/*
			for(int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
			*/
			
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						count++;
					}
				}
			}
			// 사각지대 영역 개수세기
			min = Math.min(min, count);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = copy[i][j];
				}
			}
			// 바꾼 map을 본래대로 돌려놓는다.
			
			return;
		}
		
		for(int i = 1; i <= 4; i++) {
			arr[depth] = i;
			pro(arr, depth+1);
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
	}
}
/*
4 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
*/