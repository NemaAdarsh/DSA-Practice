class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = find(nums, target, true);
        if (left == -1) return new int[]{-1, -1};
        int right = find(nums, target, false);
        return new int[]{left, right};
    }

    int find(int[] nums, int target, boolean first) {
        int l = 0, r = nums.length - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                ans = m;
                if (first) r = m - 1;
                else l = m + 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
