class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        d, s = {}, []
        for n in nums2:
            while s and s[-1] < n: d[s.pop()] = n
            s.append(n)
        return [d.get(n, -1) for n in nums1]
