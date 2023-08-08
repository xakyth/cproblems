package leetcode.mix;

public class cp11 {
    public int maxArea(int[] height) {
        int best = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int cur = (r - l + 1) * Math.min(height[l], height[r]);
            if (cur > best) {
                best = cur;
            }
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return best;
    }
}