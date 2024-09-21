package bj1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K, N; // K: 이미 가지고 있는 랜선의 개수, N: 필요한 랜선의 개수
	static int[] lan;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
		N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		lan = new int[K];
		int maxLength = 0;
		for (int i=0; i<K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			if (lan[i] > maxLength) {
				maxLength = lan[i];
			}
		}
		// N개를 만들 수 있는 랜선의 최대 길이
		long shortest = 1;
		long longest = maxLength;
		while (shortest <= longest) {
			long mid = (shortest + longest) / 2; // 정수 오버플로우 방지
			long pieces = makeLanIntoPieces(mid);
			if (pieces >= N) {
				shortest = mid + 1;
			} else {
				longest = mid - 1;
			}
		}
		
		System.out.println(longest);
	}
	
	static long makeLanIntoPieces(long l) {
		long count = 0;
		for (int i=0; i<K; i++) {
			count += lan[i] / l;
		}
		
		return count;
	}
}
