package swea16504;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1; i<=t; i++) {
			int row = sc.nextInt();
			int[] arr = new int[row];
			for (int j=0; j<row; j++) {
				arr[j] = sc.nextInt();
			}
			int max = 0;
			for (int j=0; j<arr[0]; j++) {
				int cnt = 0;
				for (int k=1; k<row; k++) {
					if (arr[k] == 0 || j+1 > arr[k])
						cnt++;
				}
				max = Math.max(max, cnt);
			}
			System.out.println("#"+(i)+" "+max);
		}
		sc.close();
	}
}
