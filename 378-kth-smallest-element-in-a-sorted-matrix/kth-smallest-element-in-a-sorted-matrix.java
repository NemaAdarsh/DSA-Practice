class Solution{
    public int kthSmallest(int[][] m,int k){
        int n=m.length,l=m[0][0],r=m[n-1][n-1];
        while(l<r){
            int mid=l+(r-l)/2,c=0,j=n-1;
            for(int i=0;i<n;i++){
                while(j>=0&&m[i][j]>mid) j--;
                c+=j+1;
            }
            if(c<k) l=mid+1;
            else r=mid;
        }
        return l;
    }
}
