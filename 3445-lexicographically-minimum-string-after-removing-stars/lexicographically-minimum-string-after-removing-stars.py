class Solution:
    def clearStars(self, s: str) -> str:
        res, pos = [], [[] for _ in range(26)]
        for i, c in enumerate(s):
            if c == '*':
                for j in range(26):
                    if pos[j]:
                        res[pos[j].pop()] = ''
                        break
            else:
                res.append(c)
                pos[ord(c)-97].append(len(res)-1)
        return ''.join(res)
