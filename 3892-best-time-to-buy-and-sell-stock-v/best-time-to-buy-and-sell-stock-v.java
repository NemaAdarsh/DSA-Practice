class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long NEG = Long.MIN_VALUE / 4;
        long[][][] dp = new long[n + 1][k + 1][3];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                dp[i][j][1] = dp[i][j][2] = NEG;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i + 1][j][0] = Math.max(dp[i + 1][j][0], dp[i][j][0]);
                dp[i + 1][j][1] = Math.max(dp[i + 1][j][1], dp[i][j][1]);
                dp[i + 1][j][2] = Math.max(dp[i + 1][j][2], dp[i][j][2]);

                dp[i + 1][j][1] = Math.max(dp[i + 1][j][1], dp[i][j][0] - prices[i]);
                dp[i + 1][j][2] = Math.max(dp[i + 1][j][2], dp[i][j][0] + prices[i]);

                if (j < k) {
                    dp[i + 1][j + 1][0] = Math.max(dp[i + 1][j + 1][0], dp[i][j][1] + prices[i]);
                    dp[i + 1][j + 1][0] = Math.max(dp[i + 1][j + 1][0], dp[i][j][2] - prices[i]);
                }
            }
        }

        long ans = 0;
        for (int j = 0; j <= k; j++) ans = Math.max(ans, dp[n][j][0]);
        return ans;
    }
}
