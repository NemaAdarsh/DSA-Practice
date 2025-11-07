class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n];
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + stations[i];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right + 1] - prefix[left];
        }

        long low = 0, high = (long)1e18, ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (canAchieve(power, r, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] diff = new long[n + 1];
        long added = 0, used = 0;

        for (int i = 0; i < n; i++) {
            added += diff[i]; 
            long currPower = power[i] + added;

            if (currPower < target) {
                long need = target - currPower;
                used += need;
                if (used > k) return false;

                added += need; 
                int end = i + 2 * r + 1;
                if (end < n) diff[end] -= need; 
            }
        }
        return true;
    }
}
