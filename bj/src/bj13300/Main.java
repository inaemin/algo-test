package bj13300;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 학생 수와 방의 최대 인원 수 입력
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		// 상수 정의
		final int MAX_GRADES = 6;
		final int GENDERS = 2;
		// 학생 수 카운트 배열 초기화
		int[][] students = new int[MAX_GRADES+1][MAX_GRADES];
		
		// 학생 정보 입력
		for (int i=0; i<n; i++) {
			int gender = sc.nextInt();
			int grades = sc.nextInt();
			students[grades][gender]++;
		}
		
		// 필요한 방의 수 계산
		int cnt = 0;
		for (int i=1; i<7; i++) {
			for (int j=0; j<2; j++) {
				// 각 성별, 학년별로 필요한 방의 수 계산
				cnt += (students[i][j] + k - 1) / k;
			}
		}
		
		// 결과 출력
		System.out.println(cnt);
		
		sc.close();
	}
}
