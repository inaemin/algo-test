package swea1289;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 개수
        int tc = sc.nextInt();
        for (int t=1; t<=tc; t++) {
        	// 메모리 입력
            String memory = "0" + sc.next();
            // 메모리 숫자가 달라지는 구간을 카운트
            int cnt = 0;
            for (int i=0; i<memory.length()-1; i++) {
                if (memory.charAt(i) != memory.charAt(i+1)) {
                    cnt++;
                }
            }
            System.out.println("#"+t+" "+cnt);
        }
        sc.close();
    }
}
