package bj2292;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
        
        if (n == 1) {
            System.out.print(1);
            return;
        }
        
		// 6의 배수를 공차로 가지는 수열
		int cnt = 1;
		int room = 1;
		int diff = 6;
		while (room < n) {
            room += diff * cnt;  // 범위의 끝 값을 확장
            cnt += 1;            // 단계 증가
        }
		
		System.out.print(cnt);
	}
}