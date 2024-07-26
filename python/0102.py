# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []

        ans = []
        queue = [root]
        while queue:
            ans.append([node.val for node in queue])

            next = []
            for node in queue:
                if node.left: next.append(node.left)
                if node.right: next.append(node.right)
            queue = next

        return ans
