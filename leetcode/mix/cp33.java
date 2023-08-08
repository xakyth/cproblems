package leetcode.mix;

public class cp33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (nums[l] > nums[r]) {
            int m = (l + r) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int k = -1;
        if (l > 0)
            k = l - 1;
        l = 0;
        r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (k >= 0) {
                if (m >= nums.length - k - 1) {
                    m = m - (nums.length - k - 1);
                } else {
                    m = m + k + 1;
                }
            }
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = (l + r) / 2;
            } else {
                l = (l + r) / 2 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        cp33 c = new cp33();
        c.search(new int[] { 0, 1, 2 }, 0);        
    }
}
