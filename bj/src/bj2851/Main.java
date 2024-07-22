package bj2851;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = 0;
		for (int i=0; i<10; i++) {
			int n = sc.nextInt();
			int diff1 = Math.abs(100 - score);
			int diff2 = Math.abs(100 - (score + n));
			if (diff1 < diff2) {
				break;
			} else {
				score += n;
			}
		}
		System.out.println(score);
		sc.close();
		
	}
}
