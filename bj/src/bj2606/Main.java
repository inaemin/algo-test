package bj2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] graph = new int[V+1][V+1];
		for (int i=0; i<E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start][end] = 1;
			graph[end][start] = 1;
		}
		
		boolean[] visited = new boolean[V+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			visited[v] = true;
			for (int i=1; i<=V; i++) {
				if (graph[v][i] == 1 && !visited[i]) {
					queue.add(i);
				}
			}
		}
		
		int count = 0;
		for (int i=2; i<=V; i++) {
			if (visited[i])
				count++;
		}
		
		System.out.println(count);
		sc.close();
	}
}