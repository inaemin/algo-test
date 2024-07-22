package bj2567;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean[][] board = new boolean[100][100];
		Scanner sc = new Scanner(System.in);
		int papers = sc.nextInt();
		for (int i=0; i<papers; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j=x; j<x+10; j++) {
				for (int k=y; k<y+10; k++) {
					board[j][k] = true;
				}
			}
		}
		
		int round = 0;
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if (board[i][j]) {
					if ((i-1 >=0 && board[i-1][j] == false) || i == 0)
						round++;
					if ((j-1 >= 0 && board[i][j-1] == false) || j == 0)
						round++;
					if ((i+1 < 100 && board[i+1][j] == false) || i == 99)
						round++;
					if ((j+1 < 100 && board[i][j+1] == false) || j == 99)
						round++;
				}
			}
		}
		System.out.println(round);
		sc.close();
	}
}
