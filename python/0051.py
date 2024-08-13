class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        ans = []
        def dfs(row, cols, downhill, uphill, queens):
            if row == n:
                ans.append(["".join(a) for a in queens])
                return
            
            for col, used in enumerate(cols):
                if not used and row-col not in downhill and row+col not in uphill:
                    cols[col] = True
                    downhill.add(row-col)
                    uphill.add(row+col)
                    queens[row][col] = "Q"

                    dfs(row+1, cols, downhill, uphill, queens)

                    cols[col] = False
                    downhill.remove(row-col)
                    uphill.remove(row+col)
                    queens[row][col] = "."

        dfs(0, [False] * n, set(), set(), [["." for i in range(n)] for i in range(n)])
        
        return ans
