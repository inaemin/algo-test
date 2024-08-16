package swea1940;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			// 현재 속도
			int speed = 0;
			// 이동한 거리
			int distance = 0;
			for (int i=0; i<N; i++) {
				int command = sc.nextInt();
				// 0: 현재 속도 유지
				if (command == 0) {
					distance += speed * 1;
				// 1: 가속
				} else if (command == 1) {
					speed += sc.nextInt();
					distance += speed * 1;
				// 2: 감속	
				} else {
					int dec = sc.nextInt();
					if (speed < dec )
						speed = 0;
					else 
						speed -= dec;
					distance += speed * 1;					
				}
			}
			System.out.println("#"+t+" "+distance);
		}
		sc.close();
	}
}
