class Solution:
    def minSteps(self, n: int) -> int:
        if n == 1: return 0

        for i in range(n // 2, 1, -1):
            temp = n // i
            if temp * i == n:
                return temp + self.minSteps(i)
        
        return n

