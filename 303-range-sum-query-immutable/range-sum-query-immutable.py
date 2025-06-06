class NumArray:
    def __init__(self, nums):
        self.s = [0]
        for n in nums: self.s.append(self.s[-1] + n)
    def sumRange(self, l, r):
        return self.s[r+1] - self.s[l]
