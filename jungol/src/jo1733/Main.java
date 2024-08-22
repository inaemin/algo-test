package jo1733;

import java.util.Scanner;

public class Main {
	static final int N = 19;
	static int[][] board;
	static int[] deltaX = {1, 1, 1, 0};
	static int[] deltaY = {-1, 0, 1, 1};
	static int startX, startY;
	static int winnerColor = 0;
	
	public static void main(String[] args) {
		// 검은 바둑알은 1, 흰 바둑알은 2, 알이 놓이지 않는 자리 0
		// 검은색이 이겼을 경우 1, 흰색이 이겼을 경우 2, 승부가 결정되지 않았을 경우 0;
		// 가장 왼쪽에 있는 바둑알(세로로 놓인 경우, 그 중 가장 위에 있는 것)의 가로줄 번호, 세로줄 번호를 출력.
		Scanner sc = new Scanner(System.in);
		board = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		// 돌을 만나면 검사
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (board[i][j] != 0) {
					int[] result = isWon(i, j, board[i][j]);
					if (result[0] != -1) {
						startX = result[0] + 1; // 보드는 1부터 시작
						startY = result[1] + 1; // 보드는 1부터 시작
						winnerColor = board[i][j] == 1 ? 1 : 2;
					}
				}
			}
		}		
		
		// 출력
		// 이긴 돌의 색
		System.out.println(winnerColor);
		// 가장 왼쪽 돌의 좌표
		if (winnerColor != 0)
			System.out.println(startX +" "+ startY);

		sc.close();
	}
	
	static int[] isWon(int i, int j, int color) {
		int[] result = {-1, -1};
		next: for (int d=0; d<4; d++) {
			int dx, dy;
			for (int k=4; k>=0; k--) {
				dx = i + deltaX[d] * k;
				dy = j + deltaY[d] * k;
				if (dx < 0 || dx >= N || dy < 0 || dy >= N)
					continue next;
				if (board[dx][dy] != color)
					continue next;
			}
			// 육목 이상인 경우도 안됨.
			// 앞뒤로 하나씩만 확인
			dx = i + deltaX[d] * -1;
			dy = j + deltaY[d] * -1;
			if (dx >= 0 && dx < N && dy >= 0 && dy < N && board[dx][dy] == color)
				continue next;
			dx = i + deltaX[d] * 5;
			dy = j + deltaY[d] * 5;
			if (dx >= 0 && dx < N && dy >= 0 && dy < N && board[dx][dy] == color)
				continue next;
			// 오목 결과 저장
			result[0] = i;
			result[1] = j;
			if (d == 0) {
				result[0] = i + deltaX[d] * 4;
				result[1] = j + deltaY[d] * 4;
			}
		}
		return result;
	}
}
