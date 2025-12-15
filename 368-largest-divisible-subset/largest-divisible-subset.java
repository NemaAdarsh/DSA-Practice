class Solution{
    public List<Integer> largestDivisibleSubset(int[] a){
        java.util.Arrays.sort(a);
        int n=a.length,m=0,idx=0;
        int[] dp=new int[n],p=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;p[i]=-1;
            for(int j=0;j<i;j++)
                if(a[i]%a[j]==0&&dp[j]+1>dp[i]){dp[i]=dp[j]+1;p[i]=j;}
            if(dp[i]>m){m=dp[i];idx=i;}
        }
        java.util.List<Integer> r=new java.util.ArrayList<>();
        for(;idx!=-1;idx=p[idx]) r.add(a[idx]);
        return r;
    }
}
