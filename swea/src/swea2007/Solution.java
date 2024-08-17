package swea2007;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			String pattern = sc.next();
			int madi = 1;
			while (madi <= 10) {
				if (pattern.charAt(0) == pattern.charAt(madi)) {
					boolean isRepeat = true;
					for (int i=1; i<madi; i++) {
						if (pattern.charAt(i) != pattern.charAt(i+madi)) {
							isRepeat = false;
							break;
						}
					}
					if (isRepeat)
						break;
				}
				madi++;
			}
			// 출력
			System.out.println("#"+t+" "+madi);
		}
		sc.close();
	}
}
