import math

class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        def comb(x):
            return math.comb(x, 2) if x >= 0 else 0

        total = comb(n + 2)

        for _ in range(3):
            total -= comb(n - (limit + 1) + 2)

        for i in range(3):
            for j in range(i + 1, 3):
                total += comb(n - 2 * (limit + 1) + 2)

        if n >= 3 * (limit + 1):
            total -= comb(n - 3 * (limit + 1) + 2)

        return total
