package meituan;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		Integer i1 = new Integer(128);
		Integer i2 = new Integer(128);
		map.put(i1, 1);
		map.put(i2, 2);
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
	}
}
