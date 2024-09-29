package swea7733;

import java.util.Scanner;

public class Solution {
	static int T, N;
	static int max_piece;
	static int[][] cheese;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt(); // 치즈 한변의 길이
			cheese = new int[N][N];
			int maxTaste = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					cheese[i][j] = sc.nextInt();
					maxTaste = Math.max(maxTaste, cheese[i][j]);
				}
			} // 입력
			
			max_piece = 1; // 처음에는 한 조각
			for (int d=0; d<=maxTaste; d++) {
				visited = new boolean[N][N];
				max_piece = Math.max(max_piece, countPieces(d));
			}
			
			// 출력
			System.out.println("#"+t+" "+max_piece);
		}
		sc.close();
	}
	
	static int countPieces(int day) {
		int pieces = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (cheese[i][j] > day && !visited[i][j]) {
					dfs(i, j, day);
					pieces++;
				}
			}
		}
		
		return pieces;
	}

	private static void dfs(int i, int j, int day) {
		if (i<0 || i >= N || j<0 || j >= N || visited[i][j] || cheese[i][j] <= day)
			return;
		
		if (!visited[i][j] && cheese[i][j] > day) {
			visited[i][j] = true;
			dfs(i+1, j, day);
			dfs(i-1, j, day);
			dfs(i, j-1, day);
			dfs(i, j+1, day);			
		}
	}
}
