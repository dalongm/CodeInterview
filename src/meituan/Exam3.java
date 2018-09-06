package meituan;

import java.util.Scanner;

public class Exam3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int t = sc.nextInt();
		int[] a = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		
		// k为区间长度，t为出现次数
		if(n<k||k<t) {
			System.out.println(0);
			return;
		}
		
		int[] keys = new int[100001];
		boolean[] isTrue = new boolean[n - k + 1];
		for(int i=0;i<n;i++) {
			if(i<k) {
				keys[a[i]]++;
				if(keys[a[i]]>=t&&!isTrue[0]) {
					isTrue[0] = true;
					count++;
				}
			}else {
				keys[a[i]]++;
				keys[a[i-k]]--;
				if(keys[a[i]]>=t) {
					isTrue[i-k+1] = true;
					count++;
				}else {
					for(int j=i-k+1;j<=i;j++) {
						if(keys[a[j]]>=t) {
							isTrue[i-k+1] = true;
							count++;
							break;
						}
					}
				}
			}
		}
		
		System.out.println(count);
	}
}
