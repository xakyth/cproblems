package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class cp95 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public List<TreeNode> generateTrees(int n) {
        ArrayList<ArrayList<List<TreeNode>>> dp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
             ArrayList<List<TreeNode>> t1 = new ArrayList<>();
             for (int j = 1; j <= n; j++) {
                List<TreeNode> t2 = new ArrayList<>();
                t1.add(t2);
             }
             t1.get(i-1).add(new TreeNode(i));
             dp.add(t1);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                List<TreeNode> dpEntry = new ArrayList<>();
                for (int k = j; k <= j + i; k++) {
                    List<TreeNode> t1 = null;
                    List<TreeNode> t2 = null;
                    if (j < k) {
                        t1 = dp.get(j-1).get(k-2);
                    }
                    if (k+1 <= j+i) {
                        t2 = dp.get(k).get(j+i-1);
                    }
                    if (t1 == null && t2 != null) {
                        for (TreeNode node : t2) {
                            dpEntry.add(new TreeNode(k, null, node));
                        }
                    } else if (t1 != null && t2 != null) {
                        for (TreeNode node1 : t1) {
                            for (TreeNode node2 : t2) {
                                dpEntry.add(new TreeNode(k, node1, node2));
                            }
                        }
                    } else if (t1 != null && t2 == null) {
                        for (TreeNode node : t1) {
                            dpEntry.add(new TreeNode(k, node, null));
                        }
                    }
                }
                dp.get(j-1).set(i+j-1, dpEntry);
            }
        }
        
        return dp.get(0).get(n-1);    
    }
    public static void main(String[] args) {
        cp95 c = new cp95();
        c.generateTrees(3);

    }
}
