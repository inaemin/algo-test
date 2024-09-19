package bj10828;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Stack<Integer> stack;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		stack = new Stack<>();
		for (int i=0; i<N; i++) {
			String cm = sc.next();
			switch (cm) {
			case "push":
				stack.push(sc.nextInt());
				break;
			case "pop":
				if (stack.size() > 0) {
					System.out.println(stack.pop());					
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "top":
				if (stack.size() != 0) {
					System.out.println(stack.peek());					
				} else {
					System.out.println(-1);
				}
				break;
			}
		}
		sc.close();
	}
}
