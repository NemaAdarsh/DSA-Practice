class Solution{
    public int maxArea(int[] h){
        int l=0,r=h.length-1,m=0;
        while(l<r){
            m=Math.max(m,(r-l)*Math.min(h[l],h[r]));
            if(h[l]<h[r]) l++; else r--;
        }
        return m;
    }
}
