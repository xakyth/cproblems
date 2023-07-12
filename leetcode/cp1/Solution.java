package leetcode.cp1;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> poss = hs.get(nums[i]);
            if (poss == null) {
                poss = new ArrayList<Integer>();
            } 
            poss.add(i);
            hs.put(nums[i], poss);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            ArrayList<Integer> poss = hs.get(temp);
            if (poss != null) {
                if (nums[i] == temp) {
                    if (poss.size() > 1)
                        return new int[] { poss.get(0), poss.get(1) };
                } else {
                    return new int[] { i, poss.get(0) };
                }
                
            }
        }
        return new int[0];
    }
}