package bj1012;

import java.util.Scanner;

public class Main {
	static int T; // 테스트 케이스의 수
	static int M, N;
	static int[][] land;
	static int bug;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			land = new int[M][N];
			for (int k=0; k<K; k++) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				land[i][j] = 1;
			} // 입
			
			bug = 0;
			for (int i=0; i<M; i++) {
				for (int j=0; j<N; j++) {
					if (land[i][j] == 1) {
						dfs(i, j);
						bug++;
					}
				}
			}
			
			System.out.println(bug);
		}
		sc.close();
	}
	
	static void dfs(int i, int j) {
		if (i<0 || j<0 || i>=M || j>=N || land[i][j] != 1) {
			return;
		}
		
		land[i][j] = -1; // 방문함
		dfs(i+1, j);
		dfs(i-1, j);
		dfs(i, j-1);
		dfs(i, j+1);
	}
}
