package leetcode.cp111;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.

 */
class Solution {
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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Integer> d = new HashMap<>();
        q.add(root);
        d.put(root, 1);
        int minDepth = 0;
        TreeNode v = null;
        while ((v = q.poll()) != null) {
            if (v.left == null && v.right == null) {
                minDepth = d.get(v);
                break;
            }
            int l = d.get(v);
            if (v.left != null) {
                d.put(v.left, l + 1);
                q.offer(v.left);
            }
            if (v.right != null) {
                d.put(v.right, l + 1);
                q.offer(v.right);
            }
        }
        return minDepth;
    }
}