package bj1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N;
	static int[][] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 개수
		int M = sc.nextInt(); // 간선의 개수
		int P = sc.nextInt(); // 탐색을 시작할 정점의 번호
		graph = new int[N+1][N+1];
		for (int x=0; x<M; x++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			graph[i][j] = 1;
			graph[j][i] = 1;
		} // 입력
		
		dfs(P);
		System.out.println();
		bfs(P);
		
		sc.close();
	}
	
	static void dfs(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		boolean[] visited = new boolean[N+1];
		dfsHelper(stack, visited);
	}
	
	static void dfsHelper(Stack<Integer> stack, boolean[] visited) {
		int next = stack.pop();
		visited[next] = true;
		System.out.print(next+" ");
		for (int i=1; i<=N; i++) {
			if (graph[next][i] == 1 && !visited[i]) {
				stack.push(i);
				dfsHelper(stack, visited);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int next = queue.poll();
			System.out.print(next+" ");
			for (int i=1; i<=N; i++) {
				if (graph[next][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
