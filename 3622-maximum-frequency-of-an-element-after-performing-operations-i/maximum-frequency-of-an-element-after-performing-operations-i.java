import java.util.*;
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Map<Integer,Integer> freq = new HashMap<>();
        for (int a: nums) freq.put(a, freq.getOrDefault(a,0)+1);
        TreeMap<Integer,Integer> events = new TreeMap<>();
        for (int a: nums) {
            int L = a - k;
            int R = a + k;
            events.put(L, events.getOrDefault(L,0) + 1);
            events.put(R + 1, events.getOrDefault(R + 1,0) - 1);
        }
        int ans = 0;
        List<Integer> distinctNums = new ArrayList<>(freq.keySet());
        Collections.sort(distinctNums);
        int idx = 0;
        int curr = 0;
        Integer prev = events.firstKey();
        for (Map.Entry<Integer,Integer> e : events.entrySet()) {
            int key = e.getKey();
            if (prev < key) {
                ans = Math.max(ans, Math.min(curr, numOperations));
                while (idx < distinctNums.size() && distinctNums.get(idx) >= prev && distinctNums.get(idx) <= key - 1) {
                    int v = distinctNums.get(idx++);
                    ans = Math.max(ans, Math.min(curr, freq.get(v) + numOperations));
                }
            }
            curr += e.getValue();
            prev = key;
        }
        return Math.max(ans, 1);
    }
}
