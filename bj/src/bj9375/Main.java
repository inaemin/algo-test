package bj9375;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int T; // 테스트 케이스 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			HashMap<String, List<String>> closet = new HashMap<>();
			for (int i=0; i<N; i++) {
				String name = sc.next();
				String cat = sc.next();
				if (closet.containsKey(cat)) {
					closet.get(cat).add(name);
				} else {
					List<String> list = new ArrayList<>();
					list.add(name);
					closet.put(cat, list);
				}
			}
			int[] closet_arr = new int[closet.keySet().size()];
			int idx = 0;
			for (String cat : closet.keySet()) {
				closet_arr[idx] = closet.get(cat).size();
				idx++;
			}

			int count = 1; // 초기화
			for (int i=0; i<closet_arr.length; i++) {
				count *= closet_arr[i] + 1;
			}
			System.out.println(count-1); // 알몸이 아닌 상태를 위해 -1
 		}
		sc.close();
	}
}
