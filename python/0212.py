class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = {}
        for word in words:
            t = root
            for ch in word:
                if ch not in t:
                    t[ch] = {}
                t = t[ch]
            t["$"] = True
        
        m = len(board)
        n = len(board[0])
        visited = set()

        ans = []
        word = []
        
        def dfs(x, y, trie):
            if board[x][y] in trie and (x,y) not in visited:
                t = trie[board[x][y]]
                visited.add((x,y))
                word.append(board[x][y])

                if "$" in t:
                    ans.append("".join(word))
                    t.pop("$", None)

                if x > 0: dfs(x-1, y, t)
                if y > 0: dfs(x, y-1, t)
                if x < m-1: dfs(x+1, y, t)
                if y < n-1: dfs(x, y+1, t)
                
                visited.remove((x,y))
                word.pop()
        
        for i in range(m):
            for j in range(n):
                dfs(i, j, root)

        return ans
