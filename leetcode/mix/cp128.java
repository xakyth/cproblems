package leetcode.mix;

import java.util.ArrayList;
import java.util.HashSet;

public class cp128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums) {
            hs.add(n);
        }
        int best = 0;
        for (int n : nums) {
            if (!hs.contains(n - 1)) {
                int cnt = 1;
                while (hs.contains(n+1)) {
                    cnt++;
                    n = n + 1;
                }
                if (cnt > best)
                    best = cnt;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        
    }
}
