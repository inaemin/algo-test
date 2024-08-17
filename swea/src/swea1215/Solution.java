package swea1215;

import java.util.Scanner;

public class Solution {
	
	private static boolean isPalindrome(String str) {
		int n = str.length();
		for (int i=0; i<n/2; i++) {
			if (str.charAt(i) != str.charAt(n-1-i))
				return false;
		}
		return true;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int n = sc.nextInt();
			char[][] board = new char[8][8];
			for (int i=0; i<8; i++) {
				String line = sc.next();
				for (int j=0; j<8; j++) {
					board[i][j] = line.charAt(j);
				}
			}
			
			int answer = 0;
			for (int i=0; i<8; i++) {
				for (int j=0; j<=8-n; j++) {
					String row_str = "";
					for (int k=0; k<n; k++) {
						row_str += board[i][j+k];
					}
					if (isPalindrome(row_str))
						answer++;
				}
			}
			for (int i=0; i<=8-n; i++) {
				for (int j=0; j<8; j++) {
					String col_str = "";
					for (int k=0; k<n; k++) {
						col_str += board[i+k][j];
					}
					if (isPalindrome(col_str))
						answer++;
				}
			}
			
			System.out.println("#"+t+" "+answer);
		}
		sc.close();
	}
}
