import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Yonyou {

    public static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] used = new boolean[n+1];
        solve(used, n, new ArrayList<>());
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println(result.size());
    }

    public static void solve(boolean[] used, int n, List<Integer> sublist) {
        if (sublist.size() > n + 1) {
            return;
        }
        if (sublist.size() == n+1) {
            List<Integer> tempList = new ArrayList<>(n + 1);
            tempList.addAll(sublist);
            result.add(tempList);
            return;
        }
        for (int i = 0; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                sublist.add(i);
                solve(used, n, sublist);
                sublist.remove(sublist.size() - 1);
                used[i] = false;
            }

        }
    }
}
