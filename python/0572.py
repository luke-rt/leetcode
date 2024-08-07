# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def isSameTree(p, q) -> bool:
            return (not p and not q) or \
                (p and q \
                and p.val == q.val \
                and isSameTree(p.left, q.left) \
                and isSameTree(p.right, q.right))
        if isSameTree(root, subRoot): return True
        if not root: return False

        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
