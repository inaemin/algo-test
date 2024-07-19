package bj1592;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
        
		int[] arr = new int[n];
		int idx = 0;
		int cnt = 0;
		arr[idx] = 1;
		while (true) {         
            // arr[idx]가 m번 받았다면 게임 종료
			if (arr[idx] == m) break;
            
            // idx 업데이터: 홀수이면 시계방향, 짝수이면 반시계방향
			if (arr[idx] % 2 == 1) {
				idx = (idx + l) % n;
			} else {
				idx = (idx - l + n) % n; // 음수 인덱스 방지
			}
			cnt++;
			arr[idx] += 1;		
		}
		System.out.print(cnt);
        
        sc.close();
	}
}