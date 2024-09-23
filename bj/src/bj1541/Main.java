package bj1541;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// -를 기준으로 나누고 차례대로 계산
		String[] expression = sc.next().split(Pattern.quote("-"));
		int ans = calculate(expression[0]);
		for (int i=1; i<expression.length; i++) {
			ans -= calculate(expression[i]);
		}
		
		System.out.println(ans);
		sc.close();
	}
	
	static int calculate(String arg) {
		String[] nums = arg.split(Pattern.quote("+"));
		int sum = 0;
		for (int i=0; i<nums.length; i++) {
			sum += Integer.parseInt(nums[i]);
		}
		
		return sum;
	}
}
