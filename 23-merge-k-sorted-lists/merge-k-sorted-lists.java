class Solution{
    public ListNode mergeKLists(ListNode[] l){
        java.util.PriorityQueue<ListNode> q=new java.util.PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode x:l) if(x!=null) q.add(x);
        ListNode d=new ListNode(),c=d;
        while(!q.isEmpty()){
            c.next=q.poll(); c=c.next;
            if(c.next!=null) q.add(c.next);
        }
        return d.next;
    }
}
