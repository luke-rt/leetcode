class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        ans = []
        dq = deque()

        l = r = 0

        while r < len(nums):
            while dq and nums[r] > nums[dq[-1]]:
                dq.pop()
            dq.append(r)

            if r - l == k-1:
                ans.append(nums[dq[0]])

                if dq[0] == l: dq.popleft()
                l += 1
            
            r += 1
        
        return ans
            
