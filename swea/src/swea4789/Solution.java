package swea4789;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			String claps = sc.next();
			// claps[0] -> 0명일때 박수치는 사람
			// claps[1] -> 1명일때 박수치는 사람
			// 모든 관객이 기립 박수를 하게 하기 위한 최소 사람 수
			int person = 0;
			int total = 0;
			for (int i=0; i<claps.length(); i++) {
				if (i <= total) {
					total += claps.charAt(i) - '0';
				} else {
					int diff = i - total;
					person += diff;
					total += diff;
					total += claps.charAt(i) - '0';
				}
			}
			// 출력
			System.out.println("#"+t+" "+person);
		}
		sc.close();
	}
}
