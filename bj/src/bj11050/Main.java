package bj11050;

import java.util.Scanner;

public class Main {
	static int[] F; // 팩토리얼 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		F = new int[N+1];
		F[0] = 1;
		F[1] = 1;
		System.out.println(factorial(N) / factorial(N-K) / factorial(K));
		sc.close();
	}
	
	static int factorial(int n) {
		if (F[n] != 0) {
			return F[n];
		}
		
		return F[n] = factorial(n-1) * n;		
	}
}
