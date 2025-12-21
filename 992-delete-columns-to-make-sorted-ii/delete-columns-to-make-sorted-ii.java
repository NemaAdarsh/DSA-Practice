class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length(), res = 0;
        boolean[] ok = new boolean[n - 1];
        for (int c = 0; c < m; c++) {
            boolean bad = false;
            for (int i = 0; i < n - 1; i++) {
                if (!ok[i] && strs[i].charAt(c) > strs[i + 1].charAt(c)) {
                    bad = true;
                    break;
                }
            }
            if (bad) {
                res++;
            } else {
                for (int i = 0; i < n - 1; i++) {
                    if (strs[i].charAt(c) < strs[i + 1].charAt(c)) {
                        ok[i] = true;
                    }
                }
            }
        }
        return res;
    }
}
