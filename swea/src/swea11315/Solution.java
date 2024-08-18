package swea11315;

import java.util.Scanner;

public class Solution {
	
	private static int calculateHeight(char[][] pond, int i, int j) {
		int[] dx = {0, 0, -1,-1,-1, 1, 1, 1};
		int[] dy = {-1, 1, -1, 0, 1, -1, 0, 1};
		
		int height = 0;
		for (int k=0; k<8; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			if (x >= 0 && x < pond.length 
					&& y >= 0 && y < pond.length 
					&& pond[x][y] == 'W')
				height++;
		}
		return height;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			char[][] pond = new char[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					pond[i][j] = sc.next().charAt(0);
				}
			}
			
			int max_deep = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					max_deep = Math.max(calculateHeight(pond, i ,j), max_deep);
				}
			}
			
			// 출력
			System.out.println("#"+t+" "+max_deep);
		}
		sc.close();
	}
}
