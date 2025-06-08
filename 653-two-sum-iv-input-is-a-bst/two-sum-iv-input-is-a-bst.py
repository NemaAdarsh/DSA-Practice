class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        s = set()
        def dfs(node):
            if not node: return False
            if k - node.val in s: return True
            s.add(node.val)
            return dfs(node.left) or dfs(node.right)
        return dfs(root)
