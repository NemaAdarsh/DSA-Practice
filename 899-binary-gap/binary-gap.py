class Solution:
    def binaryGap(self, n: int) -> int:
        return max([j - i for i, j in zip([i for i, b in enumerate(bin(n)) if b == '1'],
                                          [i for i, b in enumerate(bin(n)) if b == '1'][1:])] or [0])
