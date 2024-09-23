package bj2630;

import java.util.Scanner;

public class Main {
	static int white_paper;
	static int blue_paper;
	static int[][] paper;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		paper = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				paper[i][j] = sc.nextInt();
			}
		} // 입력
		
		white_paper = 0;
		blue_paper = 0;
		
		dfs(0, 0, N);
		
		System.out.println(white_paper);
		System.out.println(blue_paper);
		
		sc.close();
	}
	
	static void dfs(int r, int c, int n) {
		char result = divide(r, c, n);
		if (result == 'w') {
			white_paper++;
		} else if (result == 'b') {
			blue_paper++;
		} else {
			dfs(r, c, n/2);
			dfs(r, c+n/2, n/2);
			dfs(r+n/2, c, n/2);
			dfs(r+n/2, c+n/2, n/2);
		}
	}
	
	static char divide(int start_r, int start_c, int n) {
		int white = 0;
		int blue = 0;
		for (int i=start_r; i<start_r+n; i++) {
			for (int j=start_c; j<start_c+n; j++) {
				if (paper[i][j] == 1) {
					blue++;
				} else {
					white++;
				}
			}
		}
		
		if (white == 0) {
			return 'b';
		} else if (blue == 0) {
			return 'w';
		} else {
			return 'd';
		}
	}
}
