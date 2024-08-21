class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)

        # suffix sum helps to calculate sum(piles[i:i+x])
        suffix_sum = piles.copy()
        for i in range(n-2, -1, -1):
            suffix_sum[i] += suffix_sum[i+1]
        
        # dp[i][m] is max stones starting from i with M=m+1
        dp = [[0] * (n) for _ in range(n)]

        for i in range(n-1, -1, -1):
            for m in range(n):
                # At dp[i][m], alice can [1,2(m+1)] stones to take
                if i + 2*(m+1) >= n:
                    # if you can take the rest of the stones, do it
                    dp[i][m] = suffix_sum[i]
                else:
                    for x in range(1, 2*(m+1) + 1):
                        # suffix_sum - because you want to find the highest
                        # value if alice takes x and bob the next optimal move

                        dp[i][m] = max(dp[i][m], suffix_sum[i] - dp[i+x][max(m+1, x)-1])
        
        return dp[0][0]

