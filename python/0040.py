class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        candidates.sort()

        def dfs(i, curr, curr_sum):
            if curr_sum == target:
                ans.append(curr.copy())
                return
            
            if curr_sum > target or i == len(candidates) or candidates[i] > target:
                return
            
            # left decision tree: include 1 more instance of ele i
            curr.append(candidates[i])
            dfs(i+1, curr, curr_sum + candidates[i])

            # right decision tree: do not include anymore instances of ele i
            curr.pop()
            while i < len(candidates)-1 and candidates[i] == candidates[i+1]:
                i += 1
            dfs(i+1, curr, curr_sum)

        dfs(0, [], 0)
        return ans
