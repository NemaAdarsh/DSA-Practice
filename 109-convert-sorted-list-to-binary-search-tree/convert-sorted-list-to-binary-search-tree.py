class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        def find_middle(left, right):
            slow = fast = left
            while fast != right and fast.next != right:
                slow = slow.next
                fast = fast.next.next
            return slow

        def convert(left, right):
            if left == right: return None
            mid = find_middle(left, right)
            root = TreeNode(mid.val)
            root.left = convert(left, mid)
            root.right = convert(mid.next, right)
            return root

        return convert(head, None)
