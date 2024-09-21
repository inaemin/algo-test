package bj1003;

import java.util.Scanner;

public class Main {
	static int T;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			dp = new int[41][2];
			dp[0][0] = 1;
			dp[1][1] = 1;
			
			for (int n=2; n<=N; n++) {
				dp[n][0] = dp[n-2][0] + dp[n-1][0];
				dp[n][1] = dp[n-2][1] + dp[n-1][1];				
			}

			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
		sc.close();
	}
}
