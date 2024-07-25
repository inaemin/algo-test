package jo1037;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 행렬의 크기 입력
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int row_false_cnt = 0;
		List<Integer> row_false_idx = new ArrayList<>();
		int col_false_cnt = 0;
		List<Integer> col_false_idx = new ArrayList<>();
		// 행의 합을 구하고, 홀수라면 홀수카운트를 올리고 홀수인덱스에 저장.
		for (int i=0; i<n; i++) {
			int part_sum = 0;
			for (int j=0; j<n; j++) {
				part_sum += matrix[i][j];
			}
			if (part_sum % 2 == 1) {
				row_false_cnt++;
				row_false_idx.add(i);
			}
		}
		// 열의 합을 구하고, 홀수라면 홀수카운트를 올리고 홀수인덱스에 저장.
		for (int j=0; j<n; j++) {
			int part_sum = 0;
			for (int i=0; i<n; i++) {
				part_sum += matrix[i][j];
			}
			if (part_sum % 2 == 1) {
				col_false_cnt++;
				col_false_idx.add(j);				
			}
		}
		
		// 출력
		if (row_false_cnt == 0 && col_false_cnt == 0) {
			System.out.println("OK");
		} else if (row_false_cnt != col_false_cnt) {
			System.out.println("Corrupt");
		} else {
			for (int i=0; i<row_false_cnt; i++) {
				System.out.println("Change bit (" + (row_false_idx.get(i) + 1)  + "," + (col_false_idx.get(i) + 1) + ")");
			}
		}
		sc.close();
	}
}
