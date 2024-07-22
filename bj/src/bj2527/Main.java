package bj2527;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<4; i++) {
			int[] rec1 = new int[4];
			int[] rec2 = new int[4];
			for (int j=0; j<4; j++) {
				rec1[j] = sc.nextInt();
			}
			for (int k=0; k<4; k++) {
				rec2[k] = sc.nextInt();
			}
			
			// 공통부분이 없음
			// 가로의 min이 다른 하나의 max보다 커야 함.
			// 또는 세로의 min이 다른 하나의 max보다 커야 함.
			if (rec1[0] > rec2[2] || rec2[0] > rec1[2] || rec1[1] > rec2[3] || rec2[1] > rec1[3]) {
				System.out.println("d");
			}
			
			// 점
			else if ((rec1[0] == rec2[2] && rec1[1] == rec2[3])
			|| (rec1[2] == rec2[0] && rec1[1] == rec2[3])
			|| (rec1[0] == rec2[2] && rec1[3] == rec2[1])
			|| (rec1[2] == rec2[0] && rec1[3] == rec2[1])) {
				System.out.println("c");
			}
			
			// 선분
			else if (rec1[0] == rec2[2] || rec1[2] == rec2[0] || rec1[1] == rec2[3] || rec2[1] == rec1[3]) {
				System.out.println("b");
			}
			
			// 직사각형
			else {
				System.out.println("a");
			}
		}
		sc.close();
	}
}
