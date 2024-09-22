package bj9095;

import java.util.Scanner;

public class Main {	
	static int T; // 테스트 케이스의 수
	static int N; // 정수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			int[] dp = new int[N+1];
			dp[0] = 0;
			dp[1] = 1; // 1
			if (N >= 2) {
				dp[2] = 2; // 1+1, 2				
			}
			if (N >= 3) {
				dp[3] = 4; // 1+1+1, 1+2, 2+1, 3				
			}
			for (int i=4; i<=N; i++) {
				dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
			}
			System.out.println(dp[N]);
		}
		sc.close();
	}
}
