class Solution {
    public int minOperations(int[] nums) {
        java.util.ArrayDeque<Integer> st = new java.util.ArrayDeque<>();
        int ans = 0;
        for (int x : nums) {
            if (x == 0) {
                st.clear();
                continue;
            }
            while (!st.isEmpty() && st.peek() > x) st.pop();
            if (st.isEmpty() || st.peek() < x) {
                st.push(x);
                ans++;
            }
        }
        return ans;
    }
}
