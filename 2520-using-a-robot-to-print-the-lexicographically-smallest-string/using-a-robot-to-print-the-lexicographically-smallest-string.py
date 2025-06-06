class Solution:
    def robotWithString(self, s: str) -> str:
        t, res = [], []
        min_suf = [None] * len(s)
        min_suf[-1] = s[-1]
        for i in range(len(s) - 2, -1, -1):
            min_suf[i] = min(s[i], min_suf[i+1])
        i = 0
        for c in s:
            t.append(c)
            while t and (i == len(s) - 1 or t[-1] <= min_suf[i + 1]):
                res.append(t.pop())
            i += 1
        while t:
            res.append(t.pop())
        return ''.join(res)
