class Solution:
    def minWindow(self, s: str, t: str) -> str:
        freq = {}
        for ch in t:
            if ch in freq: freq[ch] += 1
            else: freq[ch] = 1

        l = r = 0
        ans = s
        have = 0
        need = len(freq)
        while r < len(s):
            if s[r] in freq:
                freq[s[r]] -= 1
                if freq[s[r]] == 0: have += 1

                while s[l] not in freq or freq[s[l]] < 0:
                    if s[l] in freq: freq[s[l]] += 1
                    l += 1

                if have == need and r-l+1 < len(ans):
                    ans = s[l:r+1]

            r += 1
        
        if have != need: return ""
        return ans

