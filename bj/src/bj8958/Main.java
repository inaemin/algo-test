package bj8958;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			String quizResult = sc.next();
			int sum = 0;
			int consecutive = 1;
			for (int idx=0; idx<quizResult.length(); idx++) {
				if (quizResult.charAt(idx) == 'O') {
					sum += consecutive;
					consecutive++;
				} else {
					consecutive = 1;
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
