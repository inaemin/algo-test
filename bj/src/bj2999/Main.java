package bj2999;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String encrypted = sc.next();
		sc.close();
		int r = 0;
		int c = 0;
		for (int i=1; i<=encrypted.length(); i++) {
			int len = encrypted.length();
			if (len % i == 0 && i <= len / i) {
				r = i;
				c = len / i;
			} else if (i > len / i) break;
		}

		char[][] arr = new char[r][c];
		int idx = 0;
		for (int j=0; j<c; j++) {
			for (int i=0; i<r; i++) {
				arr[i][j] = encrypted.charAt(idx);
				idx++;
			}
		}
		String answer = "";
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				answer += arr[i][j];
			}
		}
		System.out.println(answer);
	}
}
