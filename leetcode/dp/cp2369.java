package leetcode.dp;

public class cp2369 {


        public boolean validPartition(int[] nums) {
            boolean[] dp = new boolean[nums.length+1];
            dp[0] = true;
            dp[1] = false;
            dp[2] = nums[0] == nums[1];
            for (int i = 3; i <= nums.length; i++) {
                if (dp[i-2] && nums[i-1] == nums[i-2]) {
                    dp[i] = true;
                } else if (dp[i-3]) {
                    if (nums[i-1] == nums[i-2] && nums[i-1] == nums[i-3]) {
                        dp[i] = true;
                    } else if (nums[i-1] - nums[i-2] == 1 && nums[i-2] - nums[i-3] == 1) {
                        dp[i] = true;
                    }
                } 
            }
            return dp[nums.length];
        }
}