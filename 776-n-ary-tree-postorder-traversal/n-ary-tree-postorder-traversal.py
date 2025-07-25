class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root: return []
        res = []
        for child in root.children:
            res += self.postorder(child)
        res.append(root.val)
        return res
