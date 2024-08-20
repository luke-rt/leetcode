class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s2) < len(s1): return False
        
        freq = defaultdict(lambda: 0)
        for ch in s1: freq[ch] += 1

        l = 0
        for r in range(len(s2)):
            freq[s2[r]] -= 1

            while freq[s2[r]] < 0:
                freq[s2[l]] += 1
                l += 1
            
            if r - l + 1 == len(s1):
                return True

            r += 1
        
        return False
