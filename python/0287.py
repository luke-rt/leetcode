class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow = 0
        fast = 0

        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast: break

        head = 0
        while True:
            slow = nums[slow]
            head = nums[head]
            if head == slow: break
        
        return head