package bj17626;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[1] = 1;
		for (int i=0; i<=N; i++) {
			dp[i] = i;
		}
		
		for (int i=0; i<=N; i++) {
			for (int j=1; i+j*j<=N; j++) {
				dp[i+j*j] = Math.min(dp[i] + 1, dp[i+j*j]);
			}
		}
		
		System.out.println(dp[N]);
		sc.close();
	}
}
