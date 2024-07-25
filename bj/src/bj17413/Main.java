package bj17413;

import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		// 태그는 <> 사이의 부분 문자열. 알파벳 소문자와 공백만 있음.
		// 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열. 연속하는 두 단어는 공백 하나로 구분.
		// 태그와 단어 사이에는 공백이 없음.
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder answer = new StringBuilder();
		StringBuilder word = new StringBuilder();
		boolean isTag = false;
		
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if (ch == '<') {
				// 태그가 시작되면 이전에 쌓인 단어를 뒤집어서 추가
				if (word.length() > 0) {
					answer.append(word.reverse());
					word.setLength(0);						
				}
				isTag = true;
				answer.append(ch);
			} else if (ch == '>') {
				// 태그가 끝나면 플래그를 바꿈.
				isTag = false;
				answer.append(ch);
			} else if (Character.isWhitespace(ch)) {
				// isTag가 false이고, 공백을 만나면 이전에 쌓인 단어를 뒤집어서 추가
				if (word.length() > 0 && !isTag) {
					answer.append(word.reverse());
					word.setLength(0);						
				}
				answer.append(ch);
			} else if (!isTag && (Character.isLowerCase(ch) || Character.isDigit(ch))) {
				word.append(ch);
			} else {
				answer.append(ch);
			}
		}
		// 마지막에 쌓인 단어를 뒤집어서 추가.
		if (word.length() > 0 && !isTag) {
			answer.append(word.reverse());
			word.setLength(0);						
		}
		System.out.println(answer);
		sc.close();
	}
}
