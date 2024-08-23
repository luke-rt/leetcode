class Solution:
    def canJump(self, nums: List[int]) -> bool:
        target = 1

        for i in range(len(nums)-2, -1, -1):
            if nums[i] < target: target += 1
            else: target = 1
        
        return target == 1
