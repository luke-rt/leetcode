# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        ans = -1000

        def aux(root: Optional[TreeNode]) -> int:
            if not root: return 0

            left = max(0, aux(root.left))
            right = max(0, aux(root.right))
            
            nonlocal ans
            ans = max(ans, root.val + left + right)

            return root.val + max(left, right)
        
        tmp = aux(root)
        return max(ans, tmp)

