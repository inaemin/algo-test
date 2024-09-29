package swea1970;

import java.util.Scanner;

public class Solution {
	static int T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int[] money = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] counts = new int[8];
			int M = sc.nextInt();
			for (int i=0; i<8; i++) {
				counts[i] = M / money[i];
				M %= money[i];
			}
			System.out.println("#"+t);
			for (int c : counts) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
