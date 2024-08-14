class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        nums.sort()
        low = 0
        high = nums[-1] - nums[0]
        
        while low < high:
            median = (low + high) // 2

            left = 0
            count = 0
            for right in range(1, len(nums)):
                while nums[right] - nums[left] > median:
                    left += 1
                count += right - left
            
            if count < k: low = median + 1
            else: high = median
        
        return low
