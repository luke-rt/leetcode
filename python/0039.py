class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        def dfs(i, curr, curr_sum):
            if curr_sum == target:
                ans.append(curr.copy())
            elif curr_sum < target and i < len(candidates):
                # Decision tree left branch: include ls[i]
                curr.append(candidates[i])
                dfs(i, curr, curr_sum + candidates[i])

                # Decision tree right branch: exclude ls[i]
                curr.pop()
                dfs(i+1, curr, curr_sum)

        dfs(0, [], 0)
        return ans
