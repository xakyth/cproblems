package leetcode.mix;

import java.util.ArrayList;
import java.util.List;

public class cp77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        search(n, k, 0, 0, result, new ArrayList<>());
        return result;
    }

    private void search(int n, int k, int i, int l, List<List<Integer>> res, ArrayList<Integer> temp) {
        if (i == k) {
            res.add((List<Integer>)temp.clone());
        } else {
            for (int j = l + 1; j <= n; j++) {
                temp.add(j);
                search(n, k, i+1, j, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        cp77 c = new cp77();
        System.out.println(c.combine(4, 2));
        
    }
}
