package swea4698;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	private static int[] sieve = new int[1000001];
	
	static {
		Arrays.fill(sieve, 1);
		sieve[0] = 0; // 소수가 아님
		sieve[1] = 0; // 소수가 아님
		for (int i=2; i<=1000000; i++) {
			if (sieve[i] == 0) { // 소수가 아님
				for (int j=1; j<=1000000/i; j++) {
					sieve[i*j] = 0;
				}
			} else { // 소수임
				for (int j=2; j<=1000000/i; j++) {
					sieve[i*j] = 0;
				}
			}
		}
	}
	
	private static boolean hasSpecialNum(int num, int special) {
		while (num > 0) {
			if (num % 10 == special) // 일의 자리 수부터 검사
				return true;
			num /= 10;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int answer = 0;
			for (int i=A; i<=B; i++) {
				if (sieve[i] == 1 && hasSpecialNum(i, D))
					answer++;
			}
			
			System.out.println("#"+t+" "+answer);
		}
		sc.close();
	}
}
