class Solution:
    def numTilings(self, n: int) -> int:
        if n == 1: return 1
        if n == 2: return 2
        if n == 3: return 5
        
        a, b, c = 1, 2, 5
        for _ in range(4, n + 1):
            a, b, c = b, c, 2 * c + a
        return c % (10**9 + 7)
