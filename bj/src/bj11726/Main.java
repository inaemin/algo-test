package bj11726;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 0, 1, 2, 3, 5
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[1] = 1;
		if (N >= 2) {
			dp[2] = 2;			
		}
		for (int i=3; i<=N; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007;
		}
		
		System.out.println(dp[N]);
		
		sc.close();
	}
}
