package bj10158;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();

		p = (p+t) % (w*2);
		if (p > w) {
			p = w - (p % w);
		}
		q = (q+t) % (h*2);
		if (q > h) {
			q = h - (q % h);
		}

		System.out.println(p + " " + q);
		sc.close();
	}
}
