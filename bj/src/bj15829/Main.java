package bj15829;

import java.util.Scanner;

public class Main {
	static int r = 31;
	static int M = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String str = sc.next();
		long sum = 0;
		long power = 1;
		for (int i=0; i<L; i++) {
			int ch = str.charAt(i) - 'a' + 1;
			sum = (sum + (ch * power % M)) % M;
			power = power * r % M;
		}
		
		System.out.println(sum);
		sc.close();
	}
}
