class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curr = 0
        ans = -math.inf
        for num in nums:
            curr += num
            ans = max(ans, curr)
            if curr < 0:
                curr = 0
    
        return ans

