# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(root, min, max) -> bool:
            if not root: return True

            if root.val <= max: return False
            if root.val >= min: return False

            return dfs(root.right, min, root.val) and dfs(root.left, root.val, max)

        return dfs(root, 2**31, -2**31 -1)
