class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1] * n

        ans = 0

        for i in range(n):
            for j in range(0, i):
                if nums[i] > nums[j]: dp[i] = max(dp[i], 1 + dp[j])
            ans = max(ans, dp[i])
        return ans
        
