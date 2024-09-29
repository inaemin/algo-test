package swea1226;

import java.util.Scanner;

public class Solution {
	static int[][] maze;
	static int end_r, end_c;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			sc.nextInt(); // 테스트 케이스의 번호
			maze = new int[16][16];
			result = 0;
			int start_r = 0, start_c = 0;
			for (int i=0; i<16; i++) {
				String line = sc.next();
				for (int j=0; j<16; j++) {
					maze[i][j] = line.charAt(j) - '0';
					if (maze[i][j] == 2) {
						start_r = i;
						start_c = j;
					} else if (maze[i][j] == 3) {
						end_r = i;
						end_c = j;
					}
				}
			} // 입력
			
			dfs(start_r, start_c);			
			
			// 출력
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}
	
	static void dfs(int i, int j) {
		if (i == end_r && j == end_c) {
			result = 1;
			return;
		}
		if (i < 0 || i >= 16 || j < 0 || j >= 16 || maze[i][j] == 1 || maze[i][j] == -1)
			return;
		
		maze[i][j] = -1;
		dfs(i+1, j);
		dfs(i-1, j);
		dfs(i, j+1);
		dfs(i, j-1);
//		if (maze[i+1][j] == 0)
//		if (maze[i-1][j] == 0)
//		if (maze[i][j-1] == 0)
//		if (maze[i][j+1] == 0)
	}
}
