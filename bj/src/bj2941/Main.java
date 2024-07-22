package bj2941;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.next().split("");
		int cnt = 0;
		for (int i=str.length-1; i>=0; i--) {
			if (str[i].equals("-")) {
				if (i-1 >= 0 && (str[i-1].equals("c") || str[i-1].equals("d"))) {
					cnt++;
					i--;
				} else {
					cnt++;
				}
			} else if (str[i].equals("=")) {
				if (i-2 >=0 && (str[i-1].equals("z") && str[i-2].equals("d"))) {
					cnt++;
					i -= 2;
				} else if (i-1 >= 0 && (str[i-1].equals("c") || str[i-1].equals("s") || str[i-1].equals("z"))) {
					cnt++;
					i--;
				} else {
					cnt++;
				}
				
			} else if (str[i].equals("j")) {
				if (i-1 >= 0 && (str[i-1].equals("l") || str[i-1].equals("n"))) {
					cnt++;
					i--;
				} else {
					cnt++;
				}
			} else {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
