class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String k = s.substring(0, 2);
            map.computeIfAbsent(k, x -> new ArrayList<>()).add(s.charAt(2));
        }
        return dfs(bottom, map);
    }
    boolean dfs(String cur, Map<String, List<Character>> map) {
        if (cur.length() == 1) return true;
        List<String> nexts = new ArrayList<>();
        build(cur, 0, new StringBuilder(), map, nexts);
        for (String n : nexts) {
            if (dfs(n, map)) return true;
        }
        return false;
    }
    void build(String cur, int i, StringBuilder sb, Map<String, List<Character>> map, List<String> res) {
        if (i == cur.length() - 1) {
            res.add(sb.toString());
            return;
        }
        String k = cur.substring(i, i + 2);
        if (!map.containsKey(k)) return;
        for (char c : map.get(k)) {
            sb.append(c);
            build(cur, i + 1, sb, map, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
