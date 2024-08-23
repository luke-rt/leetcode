class Solution:
    def jump(self, nums: List[int]) -> int:
        ans = 0

        left = right = 0
        while right < len(nums)-1:
            reach = 0
            for i in range(left, right+1):
                reach = max(reach, i+nums[i])
            
            left = right+1
            right = reach
            ans += 1

        return ans

