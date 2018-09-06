package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam1 {
	public static class Edge{
		public int x;
		public int y;
		public Edge(int x, int y) {
			if(x>y) {
				this.x = y;
				this.y = x;
			}else {
				this.x = x;
				this.y = y;
			}
		}
	}
	
	public static List<Edge> list = new ArrayList<Edge>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new Edge(x,y));
		}
		sc.close();
	}
	public static void findLongest(List<Edge> list, List<Edge> sublist, boolean[] visited) {
		
	}
}
