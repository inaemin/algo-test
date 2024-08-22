package jo1205;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] cards;
	
	public static void main(String[] args) {
		// 입력한 카드들을 가지고 만들 수 잇는 스트레이트의 최대 길이
		Scanner sc = new Scanner(System.in);
		// 카드 입력
		N = sc.nextInt();
		cards = new int[N];
		int zero_cnt = 0; // 조커 개수
		for (int i=0; i<N; i++) {
			int num = sc.nextInt();
			if (num == 0)
				zero_cnt++;
			cards[i] = num;
		}
		// 카드 오름차순 정렬
		Arrays.sort(cards);
		// 최대길이
		int max_len = zero_cnt;
		for (int i=zero_cnt; i<N; i++) {
			int joker = zero_cnt;
			int prev_c = cards[i];
			int len = 1;
			// 시작점
			for (int j=i+1; j<N; j++) {
				if (cards[j] == prev_c) {
					prev_c = cards[j];
					continue;					
				} else if (cards[j] == prev_c + 1) {
					prev_c = cards[j];					
					len++;
				} else if (cards[j] - prev_c - 1 <= joker) {
					len += cards[j] - prev_c;
					joker -= cards[j] - prev_c - 1;
					prev_c = cards[j];
				} else {
					len += joker;
					joker -= joker;
					break;
				}
			}
			// 조커가 남아있다면 마저 더해주기
			if (joker > 0)
				len += joker;
			max_len = Math.max(max_len, len);
		}
		
		// 출력
		System.out.println(max_len);
		
		sc.close();
	}
}
