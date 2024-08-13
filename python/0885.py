class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        top = bottom = rStart
        left = right = cStart
        direction = 0

        ans = [[rStart, cStart]]

        while top >= 0 or bottom <= rows-1 or left >= 0 or right <= cols-1:
            if direction == 4: direction = 0

            if direction == 0:
                right += 1
                if 0 <= rStart < rows:
                    for i in range(max(cStart, -1), min(right, cols-1)):
                        ans.append([rStart, i+1])
                cStart = right
            elif direction == 1:
                bottom += 1
                if 0 <= cStart < cols:
                    for i in range(max(rStart, -1), min(bottom, rows-1)):
                        ans.append([i+1, cStart])
                rStart = bottom
            elif direction == 2:
                left -= 1
                if 0 <= rStart < rows:
                    for i in range(min(cStart, cols), max(left, 0), -1):
                        ans.append([rStart, i-1])
                cStart = left
            else:
                top -= 1
                if 0 <= cStart < cols:
                    for i in range(min(rStart, rows), max(top, 0), -1):
                        ans.append([i-1, cStart])
                rStart = top
            
            direction += 1
        
        return ans
