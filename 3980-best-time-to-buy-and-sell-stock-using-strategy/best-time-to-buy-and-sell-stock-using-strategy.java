class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length, h = k / 2;
        long base = 0;
        for (int i = 0; i < n; i++) base += (long) strategy[i] * prices[i];

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++)
            pref[i + 1] = pref[i] + (long) strategy[i] * prices[i];
        long ans = base;


        for (int i = 0; i + k <= n; i++) {
            long old = pref[i + k] - pref[i];
            long neu = 0;
            for (int j = i + h; j < i + k; j++) neu += prices[j];
            ans = Math.max(ans, base - old + neu);
        }
        return ans;
    }
}
