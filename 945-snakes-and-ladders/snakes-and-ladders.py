class Solution:
    def snakesAndLadders(self, A: List[List[int]]) -> int:
        from collections import deque
        n = len(A)
        B = [-1]
        for i in range(n-1, -2, -1):
            row = A[i] if (n - i) % 2 else A[i][::-1]
            B += row
        q, seen = deque([(1, 0)]), set()
        while q:
            i, d = q.popleft()
            if i == n * n: return d
            for j in range(i+1, min(i+7, n*n+1)):
                k = B[j] if B[j] != -1 else j
                if k not in seen:
                    seen.add(k)
                    q.append((k, d+1))
        return -1
