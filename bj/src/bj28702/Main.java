package bj28702;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for (int i=0; i<3; i++) {
			if (sc.hasNextInt()) {
				arr[i] = sc.nextInt();
			} else {
				sc.next();
			}
		}
		for (int i=2; i>=0; i--) {
			if (arr[i] != 0) {
				int nextNum = arr[i] + 3 - i;
				if (nextNum % 15 == 0) {
					System.out.println("FizzBuzz");
				} else if (nextNum % 3 == 0) {
					System.out.println("Fizz");
				} else if (nextNum % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(nextNum);					
				}
				break;
			}
		}
		sc.close();
	}
}
