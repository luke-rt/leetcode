class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        ans = max(nums)
        minProd = maxProd = 1
        for num in nums:
            if num == 0:
                minProd = maxProd = 1
                continue

            potentials = [num * maxProd, num * minProd, num]
            maxProd = max(potentials)
            minProd = min(potentials)
            
            ans = max(ans, maxProd)

            print(maxProd, minProd, ans)

        return ans

