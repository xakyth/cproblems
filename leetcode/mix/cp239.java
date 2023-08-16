package leetcode.mix;

public class cp239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int m = -1;
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            if (m < i) {
                m = i;
                for (int j = i; j < i + k; j++) {
                    if (nums[j] >= nums[m]) {
                        m = j;
                    }
                }
            } else if (nums[i + k - 1] > nums[m]) {
                m = i + k - 1;
            }
            ans[i] = nums[m];
        }
        return ans;
    }

    public static void main(String[] args) {
        cp239 c = new cp239();
        c.maxSlidingWindow(new int[] { 1,3,-1,-3,5,3,6,7}, 3);
    }
}
