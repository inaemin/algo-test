package swea7272;

import java.util.Scanner;

public class Solution {
	private static char[] oneHole = {'A', 'D', 'O', 'P', 'Q', 'R'};
	private static int groupOfAlphabet(char C) {
		if (C == 'B') return 2;
		for (char s : oneHole) {
			if (C == s)
				return 1;
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			boolean result = true;
			String word1 = sc.next();
			String word2 = sc.next();
			if (word1.length() != word2.length()) {
				result = false;
			} else {
				for (int i=0; i<word1.length(); i++) {
					// 두 알파벳이 같은 그룹이 아니라면 false
					// 그리고 break
					if (groupOfAlphabet(word1.charAt(i)) != groupOfAlphabet(word2.charAt(i))) {
						result = false;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+(result ? "SAME" : "DIFF"));
		}
		sc.close();
	}
}
