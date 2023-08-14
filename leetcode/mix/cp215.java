package leetcode.mix;

import java.util.Random;

public class cp215 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        Random rand = new Random();
        int l = 0;
        int r = nums.length;
        int p = rand.nextInt(r - l) + l;
        p = partition(nums, p, l, r);
        while (l < r) {
            if (p == k) {
                return nums[k];
            } else if (p > k) {
                r = p;
            } else {
                l = p + 1;
            }
            p = rand.nextInt(r - l) + l;
            p = partition(nums, p, l, r);
        }

        return nums[l];
    }

    private int partition(int[] a, int pivot, int l, int r) {
        swap(a, pivot, l);
        int j = l+1;
        for (int i = l + 1; i < r; i++) {
            if (a[i] < a[l]) {
                swap(a, i, j);
                j++;
            }
        }
        swap(a, j-1, l);
        return j-1;
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
