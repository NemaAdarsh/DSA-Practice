class Solution:
    def totalNQueens(self, n: int) -> int:
        def backtrack(r):
            nonlocal count
            if r == n:
                count += 1
                return
            for c in range(n):
                if c in cols or r - c in diag1 or r + c in diag2: continue
                cols.add(c); diag1.add(r - c); diag2.add(r + c)
                backtrack(r + 1)
                cols.remove(c); diag1.remove(r - c); diag2.remove(r + c)
        count, cols, diag1, diag2 = 0, set(), set(), set()
        backtrack(0)
        return count
