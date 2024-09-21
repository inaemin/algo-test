package bj11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine()); // 수행해야 하는 연산의 수
		int S = 0;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "add":
				S |= (1 << Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				S &= ~(1 << Integer.parseInt(st.nextToken()));
				break;
			case "check":
				sb.append((((S & (1 << Integer.parseInt(st.nextToken()))) != 0) ? 1 : 0)+"\n");
				break;
			case "toggle":
				S ^= (1 << Integer.parseInt(st.nextToken()));
				break;
			case "all":
				S = (1 << 21) - 1;
				break;
			case "empty":
				S = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}
}