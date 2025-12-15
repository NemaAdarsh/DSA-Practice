class Solution{
    public ListNode reverseKGroup(ListNode h,int k){
        ListNode d=new ListNode(0,h),p=d;
        while(true){
            ListNode c=p;
            for(int i=0;i<k&&c!=null;i++) c=c.next;
            if(c==null) break;
            ListNode a=p.next,b=a.next;
            for(int i=1;i<k;i++){
                a.next=b.next;
                b.next=p.next;
                p.next=b;
                b=a.next;
            }
            p=a;
        }
        return d.next;
    }
}
