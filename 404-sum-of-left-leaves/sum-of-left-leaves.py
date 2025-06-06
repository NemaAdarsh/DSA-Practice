class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        if not root: return 0
        l = root.left
        return (l.val if l and not l.left and not l.right else self.sumOfLeftLeaves(l)) + self.sumOfLeftLeaves(root.right)
