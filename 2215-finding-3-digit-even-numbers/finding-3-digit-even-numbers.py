class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        nums = set()
        for p in permutations(digits, 3):
            if p[0] != 0 and p[2] % 2 == 0:
                nums.add(p[0] * 100 + p[1] * 10 + p[2])
        return sorted(nums)
        