package bj10163;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 색종이의 개수 입력
		int n = sc.nextInt();
		// 보드 크기 상수 정의
		final int BOARD_SIZE = 1001;
		int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
		// 색종이 정보 입력 및 보드에 색종이 번호 기록
		for (int a=1; a<=n; a++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			for (int i=x; i<x+w; i++) {
				for (int j=y; j<y+h; j++) {
					board[i][j] = a;
				}
			}
		}
		
		// 결과 저장할 배열
		int[] arr = new int[n+1];
		
		// 각 색종이가 차지하는 면적 계산
		for (int i=0; i<1001; i++) {
			for (int j=0; j<1001; j++) {
				if (board[i][j] != 0) {
					arr[board[i][j]]++;
				}
			}
		}
		
		// 각 색종이의 면적 출력
		for (int i=1; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		sc.close();
	}
}
