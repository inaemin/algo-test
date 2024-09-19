package bj10845;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int last_num = -1;
		for (int i=0; i<N; i++) {
			String cm = sc.next();
			switch (cm) {
			case "push":
				int newNum = sc.nextInt();
				queue.offer(newNum);
				last_num = newNum;
				break;
			case "pop":
				if (queue.size() > 0) {
					System.out.println(queue.poll());
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.isEmpty() ? 1 : 0);
				break;
			case "front":
				System.out.println(queue.size() > 0 ? queue.peek() : -1);
				break;
			case "back":
				System.out.println(queue.size() > 0 ? last_num : -1);
				break;
			}
		}
		sc.close();
	}
}
