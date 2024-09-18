package bj2609;

import java.util.Scanner;

public class Main {
	static int divider;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = Math.max(n, m);
		int b = Math.min(n, m);
		divider = gcd(a, b);
		System.out.println(divider);
		System.out.println(lcm(n, m));
		sc.close();
	}
	
	// 최대공약수
	static int gcd(int n, int m) {
		if (m == 0) {
			return n;
		}
		
		return gcd(m, n%m);
	}
	
	// 최소공배수
	static int lcm(int n, int m) {
		return n * m / divider;
	}
}
