package leetcode.dp;

public class cp712 {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        //init
        for (int i = 1; i < dp.length; i++)
            dp[i][0] = s1.charAt(i-1) + dp[i-1][0];
        for (int j = 1; j < dp[0].length; j++) 
            dp[0][j] = s2.charAt(j-1) + dp[0][j-1];

        for (int i = 1; i < dp.length; i++) {
            int a = s1.charAt(i-1);
            for (int j = 1; j < dp[i].length; j++) {
                int b = s2.charAt(j-1);
                dp[i][j] = (a == b) ? Math.min(dp[i-1][j-1], Math.min(dp[i-1][j] + a, dp[i][j-1] + b)) : Math.min(dp[i-1][j-1] + a + b, Math.min(dp[i-1][j] + a, dp[i][j-1] + b));
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        cp712 s = new cp712();
        System.out.println(s.minimumDeleteSum("delete", "leet"));
    }
} 