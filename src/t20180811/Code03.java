package t20180811;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2018网易，Java研发工程师笔试
 * code-3
 * 第k大的'a','z'串
 * 
 * @author dalongm
 */
public class Code03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		sc.close();

		if(k<=0) {
			System.out.println();
			return ;
		}
		
		int min = Math.min(n, m);
		long mulz = 1;
		for(int i=m+n;i>min;i--) {
			mulz *= i;
		}
		long mulm = 1;
		for(int i=min;i>1;i--) {
			mulm *= i;
		}
		if(k>mulz/mulm) {
			System.out.println(-1);
			return ;
		}
		List<List<Character>> res = new Code03().entry(n, m, k);
		
		// 输出1-k的串
		/*StringBuffer sb = null;
		for (List<Character> list : res) {
			sb = new StringBuffer();
			for (Character c : list) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}*/
		
		// 输出k串
		StringBuffer sb = new StringBuffer();
		for (Character c : res.get(k-1)) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
	
	/**
	 * @param n a的长度
	 * @param m z的长度
	 * @param k 第k个az串
	 * @return
	 */
	public List<List<Character>> entry(int n, int m, int k){
		boolean[] used = new boolean[n+m];
		List<Character> charlist = new ArrayList<Character>();
		for(int i=0;i<n;i++) {
			charlist.add('a');
		}
		for(int i=0;i<m;i++) {
			charlist.add('z');
		}
		solve(charlist, new ArrayList<Character>(), used, k);
		return result;
	}
	 List<List<Character>> result = new ArrayList<>();
	public void solve(List<Character> charlist, List<Character> sublist, boolean[] used, int k) {
		if(result.size()>k) {
			return ;
		}
		if(charlist.size()==sublist.size()) {
			List<Character> temp = new ArrayList<Character>(sublist.size());
			temp.addAll(sublist);
			result.add(temp);
			return ;
		}
		for(int i=0;i<charlist.size();i++) {
			if(used[i]||i>0&&!used[i-1]&&charlist.get(i)==charlist.get(i-1)) {
				continue;
			}
			sublist.add(charlist.get(i));
			used[i] = true;
			solve(charlist, sublist, used, k);
			sublist.remove(sublist.size()-1);
			used[i] = false;
		}
	}
	
}
