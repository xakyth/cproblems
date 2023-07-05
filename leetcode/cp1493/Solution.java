package leetcode.cp1493;

class Solution {
    public int longestSubarray(int[] nums) {
        int best = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        boolean zeros = false;
        boolean prevZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt1++;
                cnt2++;
                if (cnt1 > best) 
                    best = cnt1;
                if (cnt2 > best)
                    best = cnt2;
                prevZero = false;
            } else {
                zeros = true;
                if (prevZero) {
                    cnt1 = 0;
                    cnt2 = 0;
                } else {
                    if (cnt1 > cnt2) {
                        cnt1 = 0;
                    } else {
                        cnt2 = 0;
                    }
                }
            }
        }
        return zeros ? best : best - 1;
    }
}