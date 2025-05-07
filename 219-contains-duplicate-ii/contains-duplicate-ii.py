class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        seen = {}
        for abs, num in enumerate(nums):
            if num in seen and abs-seen[num] <= k:
                return True
            seen[num] = abs
        return False
        
        