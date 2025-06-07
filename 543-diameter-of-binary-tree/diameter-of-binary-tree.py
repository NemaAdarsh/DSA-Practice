class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diameter = 0
        def depth(node):
            if not node: return 0
            l, r = depth(node.left), depth(node.right)
            self.diameter = max(self.diameter, l + r)
            return 1 + max(l, r)
        depth(root)
        return self.diameter
