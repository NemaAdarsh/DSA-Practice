class Solution{
    public int divide(int a,int b){
        if(a==Integer.MIN_VALUE&&b==-1) return Integer.MAX_VALUE;
        long x=Math.abs((long)a),y=Math.abs((long)b),r=0;
        for(int i=31;i>=0;i--)
            if((x>>i)>=y){x-=y<<i;r+=1L<<i;}
        return ((a^b)<0)?(int)-r:(int)r;
    }
}
