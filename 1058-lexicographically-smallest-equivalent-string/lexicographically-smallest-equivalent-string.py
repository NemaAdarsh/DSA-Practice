class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        p = list(range(26))
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]
        def union(x, y):
            px, py = find(x), find(y)
            if px != py:
                p[max(px, py)] = min(px, py)
        for a, b in zip(s1, s2):
            union(ord(a)-97, ord(b)-97)
        return ''.join(chr(find(ord(c)-97)+97) for c in baseStr)
