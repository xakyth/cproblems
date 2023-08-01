package leetcode.mix;

public class cp53 {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur < 0)
                cur = 0;
            cur += nums[i];
            if (cur > best && i > 0)
                best = cur;
        }
        return best;
    }

    public static void main(String[] args) {
        cp53 c = new cp53();
    }
}
