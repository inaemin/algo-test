package bj9461;

import java.util.Scanner;

public class Main {
	static long[] P;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
		P = new long[101];
		P[0] = 0;
		P[1] = 1;
		P[2] = 1;
		for (int i=3; i<=100; i++) {
			P[i] = P[i-3] + P[i-2];
		}
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			System.out.println(P[N]);
			
		}
		sc.close();
	}
}
