# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(root, max):
            count = 0

            if root.val >= max:
                count = 1
                max = root.val

            if root.left: count += dfs(root.left, max)
            if root.right: count += dfs(root.right, max)

            return count

        return dfs(root, -10**4)
