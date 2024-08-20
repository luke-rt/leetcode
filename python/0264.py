class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp = [1] * n
        used = set()
 
        # keeps track of multiples of 2,3,5
        # for all i s.t. 0 < i < two, dp[i] * 2 is present in dp
        two = three = five = 0
        for i in range(1, n):
            dp[i] = min(dp[two] * 2, dp[three] * 3, dp[five] * 5)

            # not if/elif/else statement because multiple can be true
            # if multiple are true, increment both pointers
            if dp[i] == dp[two] * 2: two += 1
            if dp[i] == dp[three] * 3: three += 1
            if dp[i] == dp[five] * 5: five += 1
        
        return dp[-1]

