class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        vals = []


        
        while head:
            vals.append(head.val)
            head = head.next



            
        return vals == vals[::-1]
