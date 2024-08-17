package swea2005;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int[][] triangle = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<=i; j++) {
					if (j == 0)
						triangle[i][j] = 1;
					else {
						int left = (i-1 >= 0 && j-1 >= 0) ? triangle[i-1][j-1] : 0;
						int right = (i-1 >= 0 && j < n) ? triangle[i-1][j] : 0;
						triangle[i][j] = left + right;						
					}
				}
			}
			// 출력
			System.out.println("#"+t);
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (triangle[i][j] != 0)
						System.out.print(triangle[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
