class Solution:
    def rob(self, nums: List[int]) -> int:
        def dp(arr):
            rob1, rob2 = 0,0

            for i in range(len(arr)):
                rob1, rob2 = rob2, max(rob2, rob1 + arr[i])
        
            return rob2

        return max(nums[0], dp(nums[1:]), dp(nums[:-1]))

