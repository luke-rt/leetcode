# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        diameter = 0

        def dfs(root: Optional[TreeNode]) -> int:
            if not root: return 0

            left_h = dfs(root.left)
            right_h = dfs(root.right)

            nonlocal diameter
            diameter = max(diameter, left_h + right_h)

            return 1 + max(left_h, right_h)
        
        dfs(root)

        return diameter

