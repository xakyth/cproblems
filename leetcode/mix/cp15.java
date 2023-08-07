package leetcode.mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class cp15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<String> hs = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 2; j < nums.length; j++) {
                int n = -(nums[i] + nums[j]);
                search(nums, n, i, j, res, hs);
            }
        }
        return res;
    }

    private void search(int[] nums, int n, int i, int j, List<List<Integer>> res, HashSet<String> hs) {
        int l = i+1;
        int r = j-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == n) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[mid]);
                temp.add(nums[j]);
                if (!hs.contains(temp.toString())) {
                    res.add(temp);
                    hs.add(temp.toString());
                }
                break;
            } else if (nums[mid] > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }
   
}
