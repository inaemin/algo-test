package swea1961;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			// 90도 회전
			String[] arr_90 = new String[N];
			// 180도 회전
			String[] arr_180 = new String[N];
			// 270도 회전
			String[] arr_270 = new String[N];
			
			for (int j=0; j<N; j++) {
				String part = "";
				for (int i=N-1; i>=0; i--) {
					part += board[i][j];
				}
				arr_90[j] = part;
			}
			
			for (int i=N-1; i>=0; i--) {
				String part = "";
				for (int j=N-1; j>=0; j--) {
					part += board[i][j];
				}
				arr_180[N-1-i] = part;
			}
			
			for (int j=N-1; j>=0; j--) {
				String part = "";
				for (int i=0; i<N; i++) {
					part += board[i][j];
				}			
				arr_270[N-1-j] = part;
			}
			
			// 출력
			System.out.println("#"+t);
			for (int i=0; i<N; i++) {
				System.out.println(arr_90[i]+" "+arr_180[i]+" "+arr_270[i]);
			}
		}
		sc.close();
	}
}
