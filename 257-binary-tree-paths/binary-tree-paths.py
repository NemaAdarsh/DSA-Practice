class Solution:
    def binaryTreePaths(self, root):
        if not root: return []
        if not root.left and not root.right: return [str(root.val)]
        return [str(root.val) + '->' + path for child in (root.left, root.right) if child for path in self.binaryTreePaths(child)]
