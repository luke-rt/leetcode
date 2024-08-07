class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []

        def dfs(i, curr):
            if i == len(nums):
                ans.append(curr.copy())
                return
            
            # left branch: include one more instance of nums[i]
            curr.append(nums[i])
            dfs(i+1, curr)

            # right branch: do not include any more instances
            curr.pop()
            while i < len(nums)-1 and nums[i] == nums[i+1]:
                i += 1
            dfs(i+1, curr)
        
        dfs(0, [])
        return ans
