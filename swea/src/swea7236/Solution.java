package swea7236;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			String[][] pond = new String[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					pond[i][j] = sc.next();
				}
			}
			
			
		}
		sc.close();
	}
}
