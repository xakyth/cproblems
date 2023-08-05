package leetcode.dp;

public class cp96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int k = 1; k <= i/2; k++) {
                dp[i] += 2 * dp[k-1] * dp[i-k];   
            }
            if (i % 2 == 1)
                dp[i] += dp[i/2] * dp[i/2];
        }
        return dp[n];
    }
}
 