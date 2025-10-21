import java.util.*;
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        boolean center = false;
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        for (String w : map.keySet()) {
            String rev = new StringBuilder(w).reverse().toString();
            if (w.equals(rev)) {
                int cnt = map.get(w);
                res += (cnt / 2) * 4;
                if (cnt % 2 == 1) center = true;
            } else if (map.containsKey(rev)) {
                int pairs = Math.min(map.get(w), map.get(rev));
                res += pairs * 4;
                map.put(w, 0);
                map.put(rev, 0);
            }
        }
        if (center) res += 2;
        return res;
    }
}
