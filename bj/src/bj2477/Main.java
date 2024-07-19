package bj2477;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fruit = sc.nextInt();
		int[] dir_arr = new int[6];
		int[] len_arr = new int[6];
		for (int i=0; i<6; i++) {
			dir_arr[i] = sc.nextInt();
			len_arr[i] = sc.nextInt();
		}
		int maxWidth = 0;
		int maxHeight = 0;
		int maxWidthIndex = 0;
		int maxHeightIndex = 0;
		
		// 큰 직사각형의 너비와 높이 찾기
		for (int i=0; i<6; i++) {
			if ((dir_arr[i] == 1 || dir_arr[i] == 2) && maxWidth < len_arr[i]) {
				maxWidth = len_arr[i];
				maxWidthIndex = i;
			}
			if ((dir_arr[i] == 3 || dir_arr[i] == 4) && maxHeight < len_arr[i]) {
				maxHeight = len_arr[i];
				maxHeightIndex = i;
			}
		}

		int smallWidth = len_arr[(maxWidthIndex+3)%6];
		int smallHeight = len_arr[(maxHeightIndex+3)%6];
		
		int area = maxWidth * maxHeight - smallWidth * smallHeight;
		System.out.println(fruit * area);
		sc.close();
	}
}