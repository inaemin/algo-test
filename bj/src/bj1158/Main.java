package bj1158;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력 처리
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		// Deque를 사용하여 원형 큐 구현
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i=1; i<=n; i++) {
			deque.add(i);
		}
		
		// 요세푸스 순열을 저장할 리스트
		List<Integer> result = new ArrayList<>();
		
		// 요세푸스 순열 생성
		while (!deque.isEmpty()) {
			for (int i=0; i<k-1; i++) {
				deque.addLast(deque.removeFirst());
			}
			result.add(deque.removeFirst());
		}
		
		// 결과 출력
		System.out.print("<");
		for (int i=0; i<result.size(); i++) {
			System.out.print(result.get(i));
			if (i != result.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
		
		sc.close();
	}
}
