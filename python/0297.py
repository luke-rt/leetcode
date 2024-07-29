# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        serialized = ""
        def dfs(root) -> str:
            if root:
                nonlocal serialized
                serialized += str(root.val) + ","
                dfs(root.left)
                serialized += ","
                dfs(root.right)
        dfs(root)
        print(serialized)
        return serialized

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        ls = data.split(",")
        i = 0
        def aux():
            nonlocal i
            if ls[i] == "": 
                i += 1
                return None
            
            root = TreeNode(int(ls[i]))
            i += 1
            root.left = aux()
            root.right = aux()
            
            return root
        
        return aux()
        
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
