class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        q, res = [root], []
        while q:
            res.append(sum(n.val for n in q) / len(q))
            q = [c for n in q for c in (n.left, n.right) if c]
        return res
