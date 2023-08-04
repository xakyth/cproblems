package leetcode.mix;

import java.util.Arrays;

public class cp238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] hash = new int[61];
        for (int n : nums) {
            hash[n+30]++;
        }
        
        for (int i = 0; i < result.length; i++) {
            int n = nums[i];
            int p = 1;
            for (int j = 0; j < 61; j++) {
                if (n + 30 == j) {
                    if(hash[j] > 1) {
                        p *= Math.pow((j-30), (hash[j]-1));
                    }
                } else {
                    if (hash[j] > 0) {
                        p *=  Math.pow((j-30), (hash[j]));
                    }
                }
            }
            result[i] = p;
        }

        return result;
    }
    public static void main(String[] args) {
        cp238 c = new cp238();
        int[] hash = c.productExceptSelf(new int[] { 5,9,2,-9,-9,-7,-8,7,-9,10 });
        System.out.println(Arrays.toString(hash));
    }
}
