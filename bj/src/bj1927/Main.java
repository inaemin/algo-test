package bj1927;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i=0; i<N; i++) {
			int x = sc.nextInt();
			switch (x) {
			case 0:
				System.out.println(pq.isEmpty() ? 0 : pq.poll());
				break;
			default:
				pq.add(x);
				break;
			}
		}
		sc.close();
	}
}
