package bj11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사람 수 입력
		int n = sc.nextInt();
		int[] arr = new int[n];
		// 각 사람의 인출 시간 입력
		for (int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// 인출 시간을 오름차순으로 정렬
		Arrays.sort(arr);
		// 누적 합 계산
		for (int i=1; i<arr.length; i++) {
			arr[i] = arr[i] + arr[i-1];
		}
		int sum = 0;
		for (int ele : arr) {
			sum += ele;
		}
		// 결과 출력
		System.out.println(sum);
		sc.close();
	}
}
