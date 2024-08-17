package swea4047;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	private static void countCard(int[] card_cnt, char symbol) {
		switch (symbol) {
			case 'S':
				card_cnt[0]--;
				break;
			case 'D':
				card_cnt[1]--;
				break;
			case 'H':
				card_cnt[2]--;
				break;
			case 'C':
				card_cnt[3]--;
				break;
			default:
				break;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			// 카드의 무늬
			// S: 스페이드, D: 다이아몬드, H: 하트, C: 클로버 순서
			// S01D02H03H04 이런 형식으로 입력
			String cards = sc.next();
			int[] card_cnt = {13, 13, 13, 13};
			Map<Character, Set<Integer>> map = new HashMap<>();
			boolean isError = false;
			for (int i=0; i<cards.length()/3; i++) {
				char symbol = cards.charAt(3*i);
				int num = (cards.charAt(3*i+1)-'0')*10 + cards.charAt(3*i+2)-'0';
				if (map.containsKey(symbol)) {
					Set<Integer> set = map.get(symbol);
					if (set.contains(num)) {
						isError = true;
						break;
					} else
						set.add(num);
						countCard(card_cnt, symbol);
				} else {
					Set<Integer> newSet = new HashSet<>();
					newSet.add(num);
					map.put(symbol, newSet);
					countCard(card_cnt, symbol);
				}
			}
			// 출력
			System.out.print("#"+t);
			if (isError) {
				System.out.print(" ERROR");
			} else {
				for (int i=0; i<4; i++) {
					System.out.print(" "+card_cnt[i]);
				}				
			}
			System.out.println();
		}
		sc.close();
	}
}
