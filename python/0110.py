# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(root):
            if not root: return 0

            left = dfs(root.left)
            right = dfs(root.right)

            print(left, right)

            if left is None or right is None or abs(left - right) > 1:
                return None
            else:
                return 1 + max(left, right)
        
        return dfs(root) is not None
