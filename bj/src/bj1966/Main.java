package bj1966;

import java.util.Scanner;

public class Main {
	static int T; // 테스트 케이스의 수
	static int N, M; // N: 문서의 개수, M: 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 놓여있는 위치
	static int[] priorities; // 문서의 중요도 1~9
	static int[] documents; // 문서의 순서
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			// 중요도가 높을수록 빨리 뽑아야
			priorities = new int[N];
			documents = new int[10];
			for (int i=0; i<N; i++) {
				priorities[i] = sc.nextInt();
				documents[priorities[i]]++;
			}

			int p = 9; // 시작 중요도
			int order = 0;
			int curr = 0;
			out: while (p > 0) {
				// 해당 중요도 문서의 개수
				if (p >= priorities[M]) {
					while (documents[p] > 0) {
						if (priorities[curr] == p) {
							priorities[curr] = 0;
							documents[p]--;
							order++;
							if (curr == M) {
								break out;
							}
						}
						curr = (curr+1) % N;
					}
					p--;
				} else {
					break;
				}
			}
			
			System.out.println(order);
			
		}
		
		sc.close();
	}
}
