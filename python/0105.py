# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder: return None

        val = preorder[0]
        pos = inorder.index(val)

        return TreeNode(
            val, \
            self.buildTree(preorder[1:(pos+1)], inorder[:pos]), \
            self.buildTree(preorder[(pos+1):], inorder[(pos+1):]) \
            )
