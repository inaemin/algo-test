package swea7087;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			String[] titles = new String[n];
			for (int i=0; i<n; i++) {
				titles[i] = sc.next();
			}
			// 알파벳순 정렬
			Arrays.sort(titles);
			
			// 순회하면서 사용할 수 잇는 제목 개수 카운트
			int cnt = 0;
			for (int i=0; i<titles.length; i++) {
				if (titles[i].charAt(0) == (char) ('A' + cnt)) {
					cnt++;
				} else if (titles[i].charAt(0) < (char) ('A' + cnt)) {
					continue;
				} else break;
			}
			// 출력
			System.out.println("#"+t+" "+cnt);
		}
		sc.close();
	}
}
