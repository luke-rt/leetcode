class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 1:
            return [nums]
        
        ans = []
        partial = self.permute(nums[1:])
        for p in partial:
            for i in range(len(p)+1):
                temp = p.copy()
                temp.insert(i, nums[0])
                ans.append(temp)

        return ans
