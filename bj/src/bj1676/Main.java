package bj1676;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 2보다 5가 더 적기 때문에 약수 중 5의 개수만 세면 됨.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;
		int k=5;
		while (k <= N) {
			count += N/k;
			k *= 5;
		}
		
		System.out.println(count);
		
		sc.close();
	}
}