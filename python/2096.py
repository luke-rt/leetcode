# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        def search(root: Optional[TreeNode], val: int, path: List[str]) -> Optional[str]:
            if root is None: return False
            if root.val == val: return True

            path.append("L")
            if search(root.left, val, path): return True
            path.pop()

            path.append("R")
            if search(root.right, val, path): return True
            path.pop()

            return False
        
        # record paths from root to start/dest node
        start = []
        search(root, startValue, start)
        dest = []
        search(root, destValue, dest)

        # find where the paths diverge
        i = 0 # length of common path
        while(i < len(start) and i < len(dest) and start[i] == dest[i]):
            i += 1

        # where the paths diverge == common node
        ans = ["U" for _ in range(len(start) - i)]
        ans += dest[i:]

        return "".join(ans)
