package meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int t = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		
		if(n<k||k<t) {
			System.out.println(0);
			return;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int[] isTrue = new int[n - k + 1];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (i < k) {
				if (map.containsKey(a[i])) {
					map.put(a[i], map.get(a[i]) + 1);
					if (map.get(a[i]) >= t) {
						isTrue[0] = 1;
					}
				} else {
					map.put(a[i], 1);
				}
			} else {
				if (map.containsKey(a[i])) {
					map.put(a[i], map.get(a[i]) + 1);
				} else {
					map.put(a[i], 1);
				}
				map.put(a[i - k], map.get(a[i - k]) - 1);
				if (map.get(a[i - k]) == 0) {
					map.remove(a[i - k]);
				}
				if (map.get(a[i]) >= t) {
					isTrue[i - k + 1] = 1;
					count++;
				} else {
					for (Integer key : map.values()) {
						if (map.get(key) >= t) {
							isTrue[i - k + 1] = 1;
							count++;
							break;
						}
					}
				}
			}
		}
		if (isTrue[0] == 1) {
			count++;
		}
		System.out.println(count);
	}
}
