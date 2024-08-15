class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False] * (n+1)
        dp[-1] = True

        for i in range(len(s)-1, -1, -1):
            for word in wordDict:
                if s[i:].startswith(word) and dp[i+len(word)]:
                    dp[i] = True
                    break

        return dp[0]

