package bj1259;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str = sc.next();
			if (str.equals("0"))
				break;
			
			int i=0;
			boolean isPalindrome = true;
			while (i <= str.length()/2) {
				if (str.charAt(i) != str.charAt(str.length()-1-i)) {
					isPalindrome = false;
					break;
				}
				i++;
			}
			System.out.println(isPalindrome ? "yes" : "no");	
		}
		
		sc.close();
	}
}
