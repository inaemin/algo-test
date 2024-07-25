package bj17413;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// start_idx와 end_idx를 찾는다.
		// 그 부분만 reverse해서 새로운 String을 만든다.
		// 태그는 <> 사이의 부분 문자열. 알파벳 소문자와 공백만 있음.
		// 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열. 연속하는 두 단어는 공백 하나로 구분.
		// 태그와 단어 사이에는 공백이 없음.
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean isTag = false;
		int[] idx = new int[2];
		List<int[]> arr = new ArrayList<>();
		String answer = "";
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '<') {
				isTag = true;
				answer += ch;
			} else if (ch == '>') {
				isTag = false;
				answer += ch;
			} else if ()
			
			
		}
		for (int[] ele : arr) {
			System.out.println(Arrays.toString(ele));
		}
		sc.close();
	}
}
