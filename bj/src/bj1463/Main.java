package bj1463;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		for (int i=N; i>=1; i--) {
			if (i+1 <= N) {
				dp[i] = dp[i+1] + 1;
			}
			if (i*2 <= N) {
				dp[i] = Math.min(dp[i*2]+1, dp[i]);
			}
			if (i*3 <= N) {
				dp[i] = Math.min(dp[i*3]+1, dp[i]);
			}
		}

		System.out.println(dp[1]);
	
		sc.close();
	}
}
