package bj14696;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int a_card = sc.nextInt();
			int[] a = new int[4];
			for (int j=0; j<a_card; j++) {
				a[sc.nextInt() - 1]++;
			}
			int b_card = sc.nextInt();
			int[] b = new int[4];
			for (int j=0; j<b_card; j++) {
				b[sc.nextInt() - 1]++;
			}

			// 별: 4, 동그라미: 3, 네모: 2, 세모: 1
			if (a[3] != b[3]) {
				System.out.println(a[3] > b[3] ? "A" : "B");
			} else if (a[2] != b[2]) {
				System.out.println(a[2] > b[2] ? "A" : "B");
			} else if (a[1] != b[1]) {
				System.out.println(a[1] > b[1] ? "A" : "B");
			} else if (a[0] != b[0]) {
				System.out.println(a[0] > b[0] ? "A" : "B");
			} else {
				System.out.println("D");
			}
		}
		sc.close();
	}
}
