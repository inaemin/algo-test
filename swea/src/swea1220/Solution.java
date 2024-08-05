package swea1220;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int deadlockCount = 0;
			int n = sc.nextInt();
			int[][] board = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			// 1은 n극, s극에 이끌리면서 아래로 떨어짐
			// 2는 s극, n극에 이끌리면서 위로 떨어짐
			// 교착은 1, 2 순서로 나타날때만 일어남
			for (int j=0; j<n; j++) {
				boolean isN = false;
				for (int i=0; i<n; i++) {
					int magnet = board[i][j];
					if (magnet == 1) {
						isN = true;
					} else if (isN && magnet == 2) {
						deadlockCount++;
						isN = false;
					}
				}
			}
			
			System.out.println("#"+t+" "+deadlockCount);
		}
		sc.close();
	}
}