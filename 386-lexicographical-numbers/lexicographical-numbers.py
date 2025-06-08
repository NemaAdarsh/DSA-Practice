class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        res, num = [], 1
        for _ in range(n):
            res.append(num)
            if num * 10 <= n:
                num *= 10
            else:
                if num >= n: num //= 10
                num += 1
                while num % 10 == 0: num //= 10
        return res
