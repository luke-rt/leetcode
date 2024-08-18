class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0: return False

        dp = set()
        dp.add(0)
        target = total // 2

        for num in nums:
            temp = set()
            for s in dp:
                if s + num == target: return True
                temp.add(s + num)

            dp = dp.union(temp)
        
        return False

