class Solution:
    def numDecodings(self, s: str) -> int:
        next = 1 # numDecodings[i+1:]
        nextnext = 1 # numDecodings[i+2:]

        for i in range(len(s)-1, -1, -1):
            temp = next
            if s[i] == "0": next = 0
            if i < len(s)-1:
                if s[i] == "1": next += nextnext
                if s[i] == "2" and s[i+1] in "0123456": next += nextnext
            nextnext = temp
        
        return next
