class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        all_sum = sum(nums[:k])
        final_answer = all_sum


        for i in range(0,len(nums)):
            if k+i<len(nums):
                all_sum = all_sum - nums[i] + nums[k+i]
                final_answer = max(final_answer,all_sum)
            else:
                break

        return final_answer/k  