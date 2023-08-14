package leetcode.dp;


public class cp322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] >= 0) {
                    if (dp[i] >= 0) 
                        dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);                    
                    else
                        dp[i] = dp[i-coins[j]] + 1;
                }
            }
        }
        return dp[amount];
    }
}
