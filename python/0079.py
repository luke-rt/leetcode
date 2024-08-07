class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        used = set()
        def dfs(i: int, x: int, y: int):
            if board[x][y] == word[i] and (x,y) not in used:
                if i == len(word)-1: return True

                used.add((x,y))
                if x > 0 and dfs(i+1, x-1, y):
                    return True
                
                if y > 0 and dfs(i+1, x, y-1):
                    return True
                
                if x < len(board)-1 and dfs(i+1, x+1, y):
                    return True
                
                if y < len(board[0])-1 and dfs(i+1, x, y+1):
                    return True
                
                used.remove((x, y))
            
            return False
        
        for i in range(len(board)):
            for j in range(len(board[i])):
                if dfs(0, i, j): return True
