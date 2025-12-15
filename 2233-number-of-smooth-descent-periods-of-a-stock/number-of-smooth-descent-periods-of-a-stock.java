class Solution{
    public long getDescentPeriods(int[] p){
        long r=1,c=1;
        for(int i=1;i<p.length;i++){
            if(p[i-1]-p[i]==1) c++;
            else c=1;
            r+=c;
        }
        return r;
    }
}
