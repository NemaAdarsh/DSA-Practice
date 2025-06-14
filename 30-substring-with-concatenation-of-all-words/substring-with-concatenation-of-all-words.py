class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        from collections import Counter
        if not s or not words: return []
        wl, total = len(words[0]), len(words) * len(words[0])
        wcount = Counter(words)
        res = []
        for i in range(len(s) - total + 1):
            seen = [s[i + j:i + j + wl] for j in range(0, total, wl)]
            if Counter(seen) == wcount:
                res.append(i)
        return res
