package swea4012;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스
	static int N;
	static int[][] S;
	static int min_diff; // 맛의 최소
	static int[] comb; // 조합을 기록하는 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			min_diff = Integer.MAX_VALUE;
			N = sc.nextInt();
			S = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					S[i][j] = sc.nextInt();
				}
			} // 입력
			
			comb = new int[N];
			combination(0, 0, 0);
			
			// 출력
			System.out.println("#"+t+" "+min_diff);
		}
		
		sc.close();
	}
	
	static void combination(int idx, int c1, int c2) {
		if (c1 == N/2 && c2 == N/2) {
			calFlavorSum(comb);
			return;
		}
		if (c1 > N/2 || c2 > N/2 || idx >= N) {
			return;
		}

		if (c1 < N/2) {
			comb[idx] = 1;
			combination(idx+1, c1+1, c2);
			
		}
		if (c2 < N/2) {
			comb[idx] = 2;
			combination(idx+1, c1, c2+1);
		}
	}
	
	static void calFlavorSum(int[] comb) {
		int[] comb1 = new int[N/2];
		int[] comb2 = new int[N/2];
		int c1 = 0, c2 = 0;
		
		for (int i=0; i<N; i++) {
			if (comb[i] == 1) {
				comb1[c1++] = i;
			} else if (comb[i] == 2) {
				comb2[c2++] = i;
			}
		}
		
		min_diff = Math.min(min_diff, Math.abs(calFlavor(comb1) - calFlavor(comb2)));
	}
	
	static int calFlavor(int[] comb) {
		int sum = 0;
		for (int i=0; i<N/2; i++) {
			for (int j=i+1; j<N/2; j++) {
				int r = comb[i];
				int c = comb[j];
				sum += S[r][c];
				sum += S[c][r];
			}
		}
		return sum;
	}

}
