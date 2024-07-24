package bj2839;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=n/5; i>=0; i--) {
			int left = n - i*5;
			if (left >= 0 && left % 3 == 0) {
				System.out.println((left / 3) + i);
				return;
			}
		}
		System.out.println(-1);
		sc.close();
	}
}
