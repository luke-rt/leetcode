class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        ans = []
        N = len(digits)
        if N == 0: return ans

        mapping = {"2":"abc", "3":"def", "4":"ghi", "5":"jkl", "6":"mno", "7":"pqrs", "8":"tuv", "9":"wxyz"}

        def dfs(i, curr):
            if i == N:
                ans.append("".join(curr))
                return
            
            for ch in mapping[digits[i]]:
                curr.append(ch)
                dfs(i+1, curr)
                curr.pop()
    
        dfs(0, [])
        return ans

