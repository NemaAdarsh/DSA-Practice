class Solution:
  def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
    p = None  # Points the k-th node from the beginning.
    q = None  # Points the k-th node from the end.

    curr = head
    while curr:
      if q:
        q = q.next
      k -= 1
      if k == 0:
        p = curr
        q = head
      curr = curr.next

    p.val, q.val = q.val, p.val
    return head



  #please do not swap the fucking nodes like a dumbass
  #swap the values not the fucking nodes and it will work 