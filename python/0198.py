class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1: return nums[0]

        for i in range(n-3, -1, -1):
            if i + 3 < n:
                nums[i] += max(nums[i+2], nums[i+3])
            else:
                nums[i] += nums[i+2]
        
        return max(nums[0], nums[1])
        
