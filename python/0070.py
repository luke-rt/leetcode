class Solution:
    def climbStairs(self, n: int) -> int:
        prevprev = 1
        prev = 1
        
        for i in range(n-1):
            prevprev, prev = prev, prev + prevprev
        
        return prev
