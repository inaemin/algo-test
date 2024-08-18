package bj17471;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N; // 구역의 개수
	static int[] ppl; // 구역의 인구
	static int[][] graph; // 그 구역와 인접한 구역의 수, 인접한 구역의 번호.
	static int min_diff = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ppl = new int[N+1];
		for (int i=1; i<=N; i++) {
			ppl[i] = sc.nextInt();
		}
		graph = new int[N+1][];
		for (int i=1; i<=N; i++) {
			int n = sc.nextInt();
			graph[i] = new int[n];
			for (int j=0; j<n; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		// 2구역 나누기
		for (int i=1; i<(1 << N) -1; i++) {
			// 연결성 확인
			if (isValid(i)) {
				// 인구차이계산
				updateMinDiff(i);
			}
		}
				
		// 출력
		System.out.println(min_diff == Integer.MAX_VALUE ? -1 : min_diff);
		
		sc.close();		
	}
	
	// 두 그룹의 연결성 확인
	static boolean isValid(int mask) {
		return isConnected(mask) && isConnected(~mask);
	}
	
	// BFS나 DFS를 사용하여 연결성 확인
	static boolean isConnected(int mask) {		
		int start = -1;
		for (int i=0; i<N; i++) {
			// mask의 i번째 비트가 1이라면
			if ((mask & (1 << i)) != 0) {
				start = i + 1;
				break;
			}
		}
		
		if (start == -1) return false; // 해당 그룹에 속한 구역이 없음
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : graph[current]) {
				// 아직 도시에 방문하지 않았고, mask에서 next번째가 1이라면
				if (!visited[next] && (mask & (1 << (next-1))) != 0) {
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
		
		// 모든 같은 그룹 구역을 방문했는지 확인
		for (int i=1; i<=N; i++) {
			// i번째 위치를 방문했는지 검사
			if ((mask & (1 << (i-1))) != 0 && !visited[i]) {
				return false;
			}
		}
		
		return true; // 모든 구역이 연결되어 있음
	}
	
	// 두 그룹의 인구 차이 계산 및 최소값 갱신
	static void updateMinDiff(int mask) {
		int sum1 = 0;
		int sum2 = 0;
		for (int i=1; i<=N; i++) {
			// mask의 i번째 비트가 1인지의 여부를 알기 위함
			if ((mask & (1 << (i-1))) != 0) {
				sum1 += ppl[i];
			} else {
				sum2 += ppl[i];
			}
		}
		min_diff = Math.min(min_diff, Math.abs(sum1 - sum2));
	}
}
