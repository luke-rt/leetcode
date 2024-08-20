class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freq = defaultdict(lambda: 0)
        most_freq = 0

        ans = 0

        l = r = 0
        while r < len(s):
            freq[s[r]] += 1
            most_freq = max(most_freq, freq[s[r]])
            
            while (r-l+1) - most_freq > k:
                freq[s[l]] -= 1
                l += 1
            
            ans = max(ans, r-l+1)

            r += 1
        
        return ans

