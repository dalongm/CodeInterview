package ali2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam2 {
	public static class Point{
		public double x;
		public double y;
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double cross(Point p) {
			return x*p.y-p.x*y;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] strnums = line.split(",");
		double x = Double.valueOf(strnums[0]);
		double y = Double.valueOf(strnums[1]);
		
		Point p = new Point(x,y);
		
		line = sc.nextLine();
		sc.close();
		
		strnums = line.split(",");
		int length = strnums.length/2;
		List<Point> list = new ArrayList<Point>();
		List<Point> pvector = new ArrayList<Point>();
		List<Point> edgevector = new ArrayList<Point>();
		Point temp;
		int minindex = 0;
		double minlen = Integer.MAX_VALUE;
		for(int i=0;i<length;i++) {
			x = Integer.valueOf(strnums[2*i]);
			y = Integer.valueOf(strnums[2*i+1]);
			
			double distence = Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
			if(distence<minlen) {
				minlen = distence;
				minindex = i;
			}
			
			list.add(new Point(x, y));
			pvector.add(new Point(p.x-x,p.y-y));
			if(i!=0) {
				temp = list.get(i-1);
				edgevector.add(new Point(x-temp.x,y-temp.y));
			}
		}
		temp = list.get(0);
		edgevector.add(new Point(temp.x-x,temp.y-y));
		
		double[] flag = new double[length];
		boolean isyes = true;
		for(int i=0;i<length;i++) {
			flag[i] = pvector.get(i).cross(edgevector.get(i));
			if(i!=0&&flag[i]*flag[i-1]<0) {
				isyes = false;
			}
		}
		
		if(isyes) {
			System.out.println("yes,0");
		}else {
			System.out.println("no,"+Math.round(minlen));
		}
		
	}
}
