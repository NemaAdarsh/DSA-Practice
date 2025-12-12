class Solution{
    public List<List<Integer>> fourSum(int[] n,int t){
        java.util.Arrays.sort(n);
        List<List<Integer>> r=new java.util.ArrayList<>();
        int L=n.length;
        for(int i=0;i<L-3;i++){
            if(i>0&&n[i]==n[i-1]) continue;
            for(int j=i+1;j<L-2;j++){
                if(j>i+1&&n[j]==n[j-1]) continue;
                int l=j+1,rp=L-1;
                while(l<rp){
                    long s=(long)n[i]+n[j]+n[l]+n[rp];
                    if(s==t){
                        r.add(java.util.Arrays.asList(n[i],n[j],n[l],n[rp]));
                        l++; rp--;
                        while(l<rp&&n[l]==n[l-1]) l++;
                        while(l<rp&&n[rp]==n[rp+1]) rp--;
                    }else if(s<t) l++;
                    else rp--;
                }
            }
        }
        return r;
    }
}
