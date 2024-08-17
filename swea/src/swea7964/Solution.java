package swea7964;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			// 도시 수 N
			int N = sc.nextInt();
			// 이동 제한 거리 D
			int D = sc.nextInt();
			// 1번 도시부터 차례대로 각 도시에 차원관문이 남아있는지에 대한 정보
			// 1: 남아있음, 0: 파괴 당한 것
			int[] doors = new int[N];
			for (int i=0; i<N; i++) {
				doors[i] = sc.nextInt();
			}
			
			// 추가로 건설해야하는 차원관문의 개수
			int answer = 0;
			// 마지막 관문
			int lastDoor = -1;
			// 체력. 한 칸 이동할때마다 관문의 유무에 따라 리셋되거나 감소함.
			int hp = D;
			while (lastDoor < N-1) {
				if (doors[++lastDoor] == 1) {
					hp = D;
				} else {
					hp--;
				}
				
				if (hp == 0) {
					answer++;
					hp = D;
				}
			}

			// 출력
			System.out.println("#"+t+" "+answer);
			
		}
		sc.close();
	}
}
