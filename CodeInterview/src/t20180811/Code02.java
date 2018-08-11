package t20180811;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 2018网易，Java研发工程师笔试
 * code-2
 * 大丰收，数苹果
 * 
 * @author dalongm
 */
public class Code02 {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] sum = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
			if(i==0) {
				sum[i] = a[i];
			}else {
				sum[i] = sum[i-1] + a[i];
			}
		}
		int m = sc.nextInt();
		int[] q = new int[m];
		int[] temq = new int[m];
		for(int i=0;i<m;i++) {
			q[i] = sc.nextInt();
			temq[i] = q[i];
		}
		sc.close();
		Arrays.sort(temq);
		int ti = 0;
		for(int i=0;i<n&&ti<m;i++) {
			while(ti<m&&temq[ti]<=sum[i]) {
				map.put(temq[ti], i);
				ti++;
			}
		}
		while(ti<m) {
			map.put(temq[ti], -1);
			ti++;
		}
		
		for(int i=0;i<m;i++) {
			System.out.println(map.get(q[i])+1);
		}
	}
}
