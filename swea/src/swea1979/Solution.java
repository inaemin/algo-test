package swea1979;

import java.util.Scanner;

public class Solution {
	
	private static int isRowFit(int[][] puzzle, int i, int j, int k) {
		// 왼쪽이 0이거나 막혀있어야 함
		// 정확히 k칸만 1이어야 함.
		for (int k_cnt=0; k_cnt<k; k_cnt++) {
			if (j+k_cnt >= puzzle.length || puzzle[i][j+k_cnt] != 1)
				return 0;
		}
		if (j+k < puzzle.length && puzzle[i][j+k] == 1)
			return 0;
		return 1;
	}
	
	private static int isColumnFit(int[][] puzzle, int i, int j, int k) {
		// 위쪽이 0이거나 막혀있어야 함
		// 정확히 k칸만 1이어야 함.
		for (int k_cnt=0; k_cnt<k; k_cnt++) {
			if (i+k_cnt >= puzzle.length) return 0;
			if (puzzle[i+k_cnt][j] != 1) return 0;
		}
		if (i+k < puzzle.length && puzzle[i+k][j] == 1)
			return 0;
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			// 퍼즐 입력
			// 흰 부분 1
			// 검은색부분 0
			int[][] puzzle = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			
			// 가로퍼즐이 맞으려면 왼쪽이 막혀있거나 가장자리여야 하고
			// 연속해서 k개만 있어야 함
			// 세로퍼즐이 맞으려면 위쪽이 막혀있거나 가장자리여야 하고
			// 연속해서 k개만 있어야 함
			int fit_cnt = 0;
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (puzzle[i][j] == 1) {
						if (j == 0 || (j > 0 && puzzle[i][j-1] == 0)) {
							fit_cnt += isRowFit(puzzle, i, j, k);							
						}
						if (i == 0 || (i > 0 && puzzle[i-1][j] == 0)) {
							fit_cnt += isColumnFit(puzzle, i, j, k);							
						}
					}
				}
			}

			// 출력
			System.out.println("#"+t+" "+fit_cnt);
		}
		sc.close();
	}
}
