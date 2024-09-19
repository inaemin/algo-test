package bj18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 난이도 의견의 개수
		int[] level = new int[31]; // 난이도 의견
		for (int i=0; i<N; i++) {
			int option = Integer.parseInt(br.readLine());
			level[option]++;
		}
		
		// 위, 아래 제외되는 사람 수
		int exclude = (int) Math.round((double) N * 0.15);
		// 포함되는 사람 수
		int include = N - exclude * 2;
		double people = include;
		int sum = 0;
		for (int i=1; i<=30; i++) {
			if (exclude - level[i] >= 0) {
				exclude -= level[i];
			} else if (include == 0) {
				break;
			} else if (include >= level[i] - exclude) {
				sum += (level[i] - exclude) * i;
				include -= level[i] - exclude;
				exclude -= exclude;
			} else if (include < level[i] - exclude) {
				sum += include * i;
				include -= include;
				exclude -= exclude;
			}
		}
		
		if (N == 0) {
			System.out.println(0);
		} else {
			System.out.println((int) Math.round((double) sum / people));			
		}
		
		
	}
}
