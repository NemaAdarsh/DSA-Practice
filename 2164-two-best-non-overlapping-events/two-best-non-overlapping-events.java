class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        int n = events.length;
        int[][] suf = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            suf[i][0] = events[i][0];
            suf[i][1] = Math.max(suf[i + 1][1], events[i][2]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, events[i][2]);
            int l = i + 1, r = n;
            while (l < r) {
                int m = (l + r) / 2;
                if (suf[m][0] >= events[i][1] + 1) r = m;
                else l = m + 1;
            }
            if (l < n) ans = Math.max(ans, events[i][2] + suf[l][1]);
        }
        return ans;
    }
}
