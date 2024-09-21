package bj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); 
		LinkedList<Integer> stack = new LinkedList<>();
		int next = Integer.parseInt(br.readLine());
		for (int i=1; i<= N; i++) {
			stack.add(i);
			sb.append("+\n");
			while (stack.peekLast() != null && stack.peekLast() == next) {
				stack.pollLast();
				sb.append("-\n");
				if (i != N || stack.size() != 0) 
					next = Integer.parseInt(br.readLine());				
			}
		}			
		System.out.println(stack.size() == 0 ? sb.toString() : "NO");
	}
}