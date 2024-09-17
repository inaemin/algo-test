package bj4153;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int[] triangles = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
			Arrays.sort(triangles);
			if (triangles[0] == 0 && triangles[1] == 0 && triangles[2] == 0)
				break;

			int a = triangles[0];
			int b = triangles[1];
			int c = triangles[2];
			if ((a*a + b*b) == (c*c)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
			
			
		}
		sc.close();
	}
}
