class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans = []
        def dfs(i, partition, substr):
            if i == len(s): 
                if substr == "": ans.append(partition.copy())
                return
            
            substr += s[i]

            if self.isPalindrome(substr):
                partition.append(substr)
                dfs(i+1, partition, "")
                partition.pop()
            
            dfs(i+1, partition, substr)

        dfs(0, [], "")
        return ans
    
    def isPalindrome(self, ls: List[str]) -> bool:
        for i in range(0, len(ls) // 2):
            if ls[i] != ls[-(i+1)]:
                return False
        return True
