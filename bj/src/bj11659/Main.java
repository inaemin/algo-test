package bj11659;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수의 개수
		int M = sc.nextInt(); // 합을 구해야 하는 횟수
		int[] nums = new int[N+1];
		nums[0] = 0;
		for (int x=1; x<=N; x++) {
			int num = sc.nextInt();
			nums[x] = nums[x-1] + num;
		}
		for (int x=0; x<M; x++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			System.out.println(nums[j] - nums[i-1]);
		}
		
		sc.close();
	}
}
