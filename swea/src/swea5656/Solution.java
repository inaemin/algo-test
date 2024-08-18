package swea5656;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, W, H;
	static int[][] board;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int minRemaining;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			int[][] board = new int[H][W];
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			minRemaining = countRemaining(board);
			dfs(0, board);
			
			// 출력
			System.out.println("#"+t+" "+minRemaining);
		}
		sc.close();
	}
	
	static void dfs(int depth, int[][] currentBoard) {
		if (depth == N || minRemaining == 0) {
			minRemaining = Math.min(minRemaining,  countRemaining(currentBoard));
			return;
		}
		
		boolean dropped = false;
		for (int col=0; col<W; col++) {
			int[][] nextBoard = copyBoard(currentBoard);
			int row = findTopBrick(nextBoard, col);
			if (row != -1) {
				dropped = true;
				breakBricks(nextBoard, row, col);
				applyGravity(nextBoard);
				dfs(depth + 1, nextBoard);
			}
		}
		
		if (!dropped) {
			minRemaining = Math.min(minRemaining, countRemaining(currentBoard));
		}
	}
	
	static void breakBricks(int[][] board, int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, board[startX][startY]});
        board[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], power = current[2];

            for (int i = 0; i < 4; i++) {
                for (int p = 1; p < power; p++) {
                    int nx = x + dx[i] * p;
                    int ny = y + dy[i] * p;
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && board[nx][ny] > 0) {
                        queue.offer(new int[]{nx, ny, board[nx][ny]});
                        board[nx][ny] = 0;
                    }
                }
            }
        }
	}
	
	static void applyGravity(int[][] board) {
		 for (int col = 0; col < W; col++) {
            int index = H - 1;
            for (int row = H - 1; row >= 0; row--) {
                if (board[row][col] > 0) {
                    board[index][col] = board[row][col];
                    if (index != row) board[row][col] = 0;
                    index--;
                }
            }
        }
	}
	
	static int findTopBrick(int[][] board, int col) {
		for (int row=0; row<H; row++) {
			if (board[row][col] > 0) {
				return row;
			}
		}
		return -1;
	}
	
	static int[][] copyBoard(int[][] original) {
		int[][] copy = new int[H][W];
		for (int i=0; i<H; i++) {
			copy[i] = original[i].clone();
		}
		return copy;
	}
	
	static int countRemaining(int[][] board) {
		int count = 0;
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				if (board[i][j] > 0)
					count++;
			}
		}
		return count;
	}
}