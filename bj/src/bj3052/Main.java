package bj3052;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Set<Number> mods = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<10; i++) {
			mods.add(sc.nextInt() % 42);
		}
		sc.close();
		System.out.println(mods.size());
		
	}
}
