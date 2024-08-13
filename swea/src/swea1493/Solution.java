package swea1493;

import java.util.Scanner;

public class Solution {
	
	// (p, 1)의 값
	private static int calculateX(int p) {
		return p*(p+1)/2;
	}
	
	// (p, q)의 값
	private static int calculateXY(int p, int q) {
		// 2 -> 6 + 3
		// 3 -> 6 + 3+4
		// 4 -> 6 + 3+4+5
		// q -> calculateX(p) + (p+p+1+p+2+...) q-1개
		// (q-2)*(q-1)/2 + p*(q-1)
		return calculateX(p) + (q-2)*(q-1)/2 + p*(q-1);
	}
	
	// 좌표에 해당하는 값을 리턴
	private static int calculateSharp(int[] position) {
		int p = position[0];
		int q = position[1];
		
		return calculateXY(p, q);
	}
	
	// 값에 대한 좌표를 배열로 리턴 -> 이진 탐색으로 바꿀 수 있다(?)
	private static int[] calculateAnd(int p) {
		int[] result = new int[2];
		int idx = 1;
		
		while (true) {
			// 오른쪽 대각선으로 그었을때, p와 제일 근접한 x좌표를 찾고
			// 왼쪽 위로 올라가면서 p 위치를 찾는다.
			int sameLineWithP = calculateX(idx);
			if (sameLineWithP >= p) {
				result[0] = idx;
				result[1] = 1;
				for (int i=0; i<sameLineWithP - p; i++) {
					result[0]--;
					result[1]++;
				}
				break;
			}	
			idx++;
		}
		return result;
	}
	
	// 별 연산자 계산
	private static int calculateStar(int p, int q) {
		int[][] positions = new int[2][2];
		positions[0] = calculateAnd(p);
		positions[1] = calculateAnd(q);
		int[] new_position = new int[2];
		new_position[0] = positions[0][0] + positions[1][0];
		new_position[1] = positions[0][1] + positions[1][1];
		
		return calculateSharp(new_position);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// p, q 입력
			int p = sc.nextInt();
			int q = sc.nextInt();
			// 출력
			System.out.println("#"+t+" "+calculateStar(p, q));
		}
		sc.close();
	}
}
