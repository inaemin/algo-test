package bj2810;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 컵을 컵홀더에 놓을 수 있는 최대 사람의 수
		// == Math.min(컵홀더의 수, 좌석의 수)
		Scanner sc = new Scanner(System.in);
		int cup = 1;
		int n = sc.nextInt();
		String seats = sc.next();
		for (int i=0; i<seats.length(); i++) {
			if (seats.charAt(i) == 'S') {
				cup += 1;
			} else {
				cup += 1;
				i++;
			}
		}
		System.out.println(Math.min(cup,  n));
		sc.close();
		
	}
}
