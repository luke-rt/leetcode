class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        ans = 0
        low = arrays[0][0]
        high = arrays[0][-1]

        for i in range(1, len(arrays)):
            ans = max(ans, arrays[i][-1] - low, high - arrays[i][0])
            # doing the high and low recalculations after ensures that 
            # the ans calculation only compares arrays[i] to previous arrays
            high = max(high, arrays[i][-1])
            low = min(low, arrays[i][0])
        
        return ans
