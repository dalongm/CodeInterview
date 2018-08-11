package t20180811;

import java.util.Scanner;

/**
 * 2018网易，Java研发工程师笔试
 * code-1
 * 叫醒一次上高数课的小明
 * n上课时长
 * k叫醒持续时长
 * a单位时间感兴趣分数
 * t是否醒着，1为醒着
 *  
 * @author dalongm
 */
public class Code01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] a = new int[n];
		int[] t = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int maxZero = 0;
		int[] state = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			if (t[i] == 1) {
				count += a[i];
			}
			if(t[i]==0) {
				if(i==0) {
					state[i] = a[i];
				}else {
					state[i] = state[i-1] + a[i];
					if(i>=k) {
						if(t[i-k]==0) {
							state[i] = state[i] - a[i-k];
						}
					}
				}
			}else {
				if(i>0) {
					state[i] = state[i-1];
				}
				if(i>=k) {
					if(t[i-k]==0) {
						state[i] = state[i] - a[i-k];
					}
				}
			}
			if(maxZero<state[i]) {
				maxZero = state[i];
			}
		}
		sc.close();
		/*for (int i = 0; i <n; i++) {
			if(t[i]==0) {
				if(i==0) {
					state[i] = a[i];
				}else {
					state[i] = state[i-1] + a[i];
					if(i>=k) {
						if(t[i-k]==0) {
							state[i] = state[i] - a[i-k];
						}
					}
				}
			}else {
				if(i>0) {
					state[i] = state[i-1];
				}
			}
			if(maxZero<state[i]) {
				maxZero = state[i];
			}
		}*/
		
		System.out.println(count+maxZero);
	}
}
