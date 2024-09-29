package swea1952;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int[] prices = new int[4];
			for (int i=0; i<4; i++) {
				prices[i] = sc.nextInt();
			}
			int[] plan = new int[13];
			for (int i=1; i<=12; i++) {
				plan[i] = sc.nextInt();
			} // 입력
			
			int[] dp = new int[13];
			for (int i=1; i<=12; i++) {
				dp[i] = Math.min(dp[i-1] + prices[0]*plan[i], dp[i-1] + prices[1]);
				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i-3]+prices[2]);
				}
			}
			
			// 출력
			System.out.println("#"+t+" "+Math.min(prices[3], dp[12]));
		}
		sc.close();
	}
}
