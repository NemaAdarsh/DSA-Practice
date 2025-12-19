import java.util.*;

class Solution {
    int[] p;

    int find(int x) {
        return p[x] == x ? x : (p[x] = find(p[x]));
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) p[b] = a;
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        union(0, firstPerson);
        for (int i = 0; i < meetings.length; ) {
            int t = meetings[i][2];
            List<int[]> cur = new ArrayList<>();

            while (i < meetings.length && meetings[i][2] == t)
                cur.add(meetings[i++]);

            for (int[] m : cur)
                union(m[0], m[1]);

            for (int[] m : cur) {
                if (find(m[0]) != find(0)) {
                    p[m[0]] = m[0];
                    p[m[1]] = m[1];
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (find(i) == find(0)) ans.add(i);

        return ans;
    }
}
