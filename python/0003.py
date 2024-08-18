class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = r = 0
        used = set()
        ans = 0
        
        while r < len(s):
            while s[r] in used:
                used.remove(s[l])
                l += 1
            used.add(s[r])
            ans = max(ans, len(used))

            r += 1

        return ans
