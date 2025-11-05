import java.util.*;

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> big = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, TreeSet<Integer>> small = new TreeMap<>(Collections.reverseOrder());
        HashSet<Integer> inBig = new HashSet<>();
        int bigCount = 0;
        long sumBig = 0;

        for (int i = 0; i < k; i++) adjust(nums[i], 1, x, freq, big, small, inBig);
        for (Map.Entry<Integer, TreeSet<Integer>> e : big.entrySet()) {
            for (int v : e.getValue()) sumBig += 1L * e.getKey() * v;
        }
        if (!big.isEmpty()) bigCount = 0; for (TreeSet<Integer> s : big.values()) bigCount += s.size();
        ans[0] = sumBig;

        for (int i = 1; i <= n - k; i++) {
            int left = nums[i - 1], right = nums[i + k - 1];
            sumBig = adjustWithSum(left, -1, x, freq, big, small, inBig, sumBig);
            sumBig = adjustWithSum(right, 1, x, freq, big, small, inBig, sumBig);
            ans[i] = sumBig;
        }
        return ans;
    }

    long adjustWithSum(int v, int delta, int x, Map<Integer,Integer> freq,
                       TreeMap<Integer, TreeSet<Integer>> big,
                       TreeMap<Integer, TreeSet<Integer>> small,
                       HashSet<Integer> inBig, long sumBig) {
        int old = freq.getOrDefault(v, 0);
        int nw = old + delta;
        if (old > 0) {
            if (inBig.contains(v)) {
                removeFromMap(big, old, v);
                inBig.remove(v);
                sumBig -= 1L * old * v;
            } else {
                removeFromMap(small, old, v);
            }
        }
        if (nw <= 0) {
            freq.remove(v);
        } else {
            freq.put(v, nw);
            if (getBigCount(big) < x) {
                addToMap(big, nw, v);
                inBig.add(v);
                sumBig += 1L * nw * v;
            } else {
                int worstF = big.lastKey();
                int worstV = big.get(worstF).last();
                if (nw > worstF || (nw == worstF && v > worstV)) {
                    removeFromMap(big, worstF, worstV);
                    inBig.remove(worstV);
                    sumBig -= 1L * worstF * worstV;
                    addToMap(small, worstF, worstV);

                    addToMap(big, nw, v);
                    inBig.add(v);
                    sumBig += 1L * nw * v;
                } else {
                    addToMap(small, nw, v);
                }
            }
        }
        // rebalance
        while (getBigCount(big) < x && !small.isEmpty()) {
            int sf = small.firstKey();
            int sv = small.get(sf).first();
            removeFromMap(small, sf, sv);
            addToMap(big, sf, sv);
            inBig.add(sv);
            sumBig += 1L * sf * sv;
        }
        while (!big.isEmpty() && !small.isEmpty()) {
            int loF = big.lastKey();
            int loV = big.get(loF).last();
            int hiF = small.firstKey();
            int hiV = small.get(hiF).first();
            if (hiF > loF || (hiF == loF && hiV > loV)) {
                removeFromMap(big, loF, loV);
                inBig.remove(loV);
                sumBig -= 1L * loF * loV;
                removeFromMap(small, hiF, hiV);
                addToMap(big, hiF, hiV);
                inBig.add(hiV);
                sumBig += 1L * hiF * hiV;
                addToMap(small, loF, loV);
            } else break;
        }
        while (getBigCount(big) > x) {
            int wf = big.lastKey();
            int wv = big.get(wf).last();
            removeFromMap(big, wf, wv);
            inBig.remove(wv);
            sumBig -= 1L * wf * wv;
            addToMap(small, wf, wv);
        }
        return sumBig;
    }

    void adjust(int v, int delta, int x, Map<Integer,Integer> freq,
                TreeMap<Integer, TreeSet<Integer>> big,
                TreeMap<Integer, TreeSet<Integer>> small,
                HashSet<Integer> inBig) {
        int old = freq.getOrDefault(v, 0);
        int nw = old + delta;
        if (old > 0) {
            if (inBig.contains(v)) {
                removeFromMap(big, old, v);
                inBig.remove(v);
            } else removeFromMap(small, old, v);
        }
        if (nw <= 0) freq.remove(v);
        else {
            freq.put(v, nw);
            if (getBigCount(big) < x) {
                addToMap(big, nw, v);
                inBig.add(v);
            } else {
                int worstF = big.lastKey();
                int worstV = big.get(worstF).last();
                if (nw > worstF || (nw == worstF && v > worstV)) {
                    removeFromMap(big, worstF, worstV);
                    inBig.remove(worstV);
                    addToMap(small, worstF, worstV);
                    addToMap(big, nw, v);
                    inBig.add(v);
                } else addToMap(small, nw, v);
            }
        }
        while (getBigCount(big) < x && !small.isEmpty()) {
            int sf = small.firstKey();
            int sv = small.get(sf).first();
            removeFromMap(small, sf, sv);
            addToMap(big, sf, sv);
            inBig.add(sv);
        }
        while (!big.isEmpty() && !small.isEmpty()) {
            int loF = big.lastKey();
            int loV = big.get(loF).last();
            int hiF = small.firstKey();
            int hiV = small.get(hiF).first();
            if (hiF > loF || (hiF == loF && hiV > loV)) {
                removeFromMap(big, loF, loV);
                inBig.remove(loV);
                removeFromMap(small, hiF, hiV);
                addToMap(big, hiF, hiV);
                inBig.add(hiV);
                addToMap(small, loF, loV);
            } else break;
        }
        while (getBigCount(big) > x) {
            int wf = big.lastKey();
            int wv = big.get(wf).last();
            removeFromMap(big, wf, wv);
            inBig.remove(wv);
            addToMap(small, wf, wv);
        }
    }

    static void addToMap(TreeMap<Integer, TreeSet<Integer>> map, int f, int v) {
        map.computeIfAbsent(f, k -> new TreeSet<>(Collections.reverseOrder())).add(v);
    }

    static void removeFromMap(TreeMap<Integer, TreeSet<Integer>> map, int f, int v) {
        TreeSet<Integer> s = map.get(f);
        if (s != null) {
            s.remove(v);
            if (s.isEmpty()) map.remove(f);
        }
    }

    static int getBigCount(TreeMap<Integer, TreeSet<Integer>> big) {
        int cnt = 0;
        for (TreeSet<Integer> s : big.values()) cnt += s.size();
        return cnt;
    }
}
