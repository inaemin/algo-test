package swea1204;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			sc.nextInt();
			// 최빈수: 특정 자료에서 가장 여러 번 나타나는 값
			// 최빈수가 여러개 일때는 가장 큰 점수를 출력하라.
			int mode = 0;
			int mode_cnt = 0;
			int[] scores = new int[101];
			for (int i=0; i<1000; i++) {
				scores[sc.nextInt()]++;
			}
			
			for (int i=100; i>=0; i--) {
				if (scores[i] > mode_cnt) {
					mode = i;
					mode_cnt = scores[i];
				}
			}
			// 출력
			System.out.println("#"+t+" "+mode);
		}
		sc.close();
	}
}
