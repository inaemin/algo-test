package swea11315;

import java.util.Scanner;

public class Solution {
	
	private static boolean isOmokSuccess(char[][] board, int i, int j) {
		int[] dx = {1, 1, 1, 0};
		int[] dy = {-1, 0, 1, 1};
		
		for (int k=0; k<4; k++) {
			int x = i;
			int y = j;
			boolean result = true;
			for (int l=0; l<4; l++) {
				x += dx[k];
				y += dy[k];
				if (x < 0 || x >= board.length) {
					result = false;
					break;					
				}
				if (y < 0 || y >= board.length) {
					result = false;
					break;
				}
				if (board[x][y] != 'o') {
					result = false;
					break;
				}
			}
			if (result)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			// o는 돌이 있는 칸, .은 돌이 없는 칸
			char[][] board = new char[N][N];
			for (int i=0; i<N; i++) {
				String line = sc.next();
				for (int j=0; j<N; j++) {
					board[i][j] = line.charAt(j);
				}
			}
			
			boolean result = false;
			out: for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (board[i][j] == 'o' && isOmokSuccess(board, i, j)) {
						result = true;
						break out;
					}
				}
			}
			
			// 출력
			System.out.println("#"+t+" "+(result ? "YES" : "NO"));
		}
		sc.close();
	}
}
