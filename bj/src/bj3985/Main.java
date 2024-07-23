package bj3985;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int n = sc.nextInt();
		int[] cakes = new int[l+1];
		int predicted_max_cake = 0;
		int predicted_max_cake_person = 0;
		for (int i=1; i<=n; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			if (k-p+1 > predicted_max_cake) {
				predicted_max_cake_person = i;
				predicted_max_cake = k-p+1;
			}
			for (int j=p; j<=k; j++) {
				if (cakes[j] == 0) {
					cakes[j] = i;
				}
			}
		}
		int[] count = new int[n+1];
		int actual_max_cake = 0;
		int actual_max_cake_person = 0;
		for (int i=1; i<=l; i++) {
			if (cakes[i] != 0) {
				int person_idx = cakes[i];
				count[person_idx]++;
				if (count[person_idx] > actual_max_cake) {
					actual_max_cake = count[person_idx];
					actual_max_cake_person = person_idx;
				}				
			}
		}

		System.out.println(predicted_max_cake_person);
		System.out.println(actual_max_cake_person);
		sc.close();
		
	}
}
