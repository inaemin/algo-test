package bj1244;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] switches = new int[n];
        for (byte i=0; i<n; i++) {
            switches[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        for (int i=0; i<p; i++) {
            int g = sc.nextInt();
            int s = sc.nextInt();
            if (g == 1) { // 남자라면 자기가 받은 수의 배수를 토글.
                for (byte j=1; j<=n/s; j++) {
                	if (s*j <= n)
                		switches[s*j-1] ^= 1;
                }
            } else if (g == 2) { // 여자라면 좌우대칭인 구간을 찾아서 그 부분을 토글.
                switches[s-1] ^= 1; // 가운데는 무조건 토글.
                int cnt = 1;
                while (s-1-cnt >= 0 && s-1+cnt < n) {
                	if (switches[s-1-cnt] == switches[s-1+cnt]) { // 좌우대칭이라면 토글.
                        switches[s-1-cnt] ^= 1;
                        switches[s-1+cnt] ^= 1;
                    } else {
                        break;
                    }
                   	cnt++;
                }
            }
        }
        
        sc.close();
        
        // 출력은 한 줄에 20개씩 출력.
		for (int i = 0; i < n; i++) {
		    System.out.print(switches[i] + " ");
		    if ((i + 1) % 20 == 0) {
		        System.out.print("\n");
		    }
		}
    }
}