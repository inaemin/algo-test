package bj30802;

import java.util.Scanner;

public class Main {
	static int N; // 참가자의 수
	static int[] S; // 티셔츠 사이즈별 신청자의 수
	static int T, P; // t: 정수 티셔츠, p: 펜의 묶음 수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[6];
		for (int i=0; i<S.length; i++) {
			S[i] = sc.nextInt();
		}
		T = sc.nextInt();
		P = sc.nextInt();
		
		// 티셔츠를 T장씩 최소 몇 묶음 주문해야 하는지
		int tshirts = 0;
		for (int i=0; i<S.length; i++) {
			tshirts += (int) Math.ceil((double) S[i] / (double) T);
		}
		System.out.println(tshirts);
		// 펜의 P자루씩 최대 주문수, 그때 펜을 한자루씩 몇개 주문하는지.
		System.out.println((N/P) + " " + (N%P));
		sc.close();
	}
}
