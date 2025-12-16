class Solution {
    int B;
    List<Integer>[] g;
    int[] p,f;
    int[][][] dp;

    public int maxProfit(int n,int[] present,int[] future,int[][] h,int budget){
        B=budget; p=present; f=future;
        g=new ArrayList[n];
        for(int i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int[] e:h) g[e[0]-1].add(e[1]-1);
        dp=new int[n][2][B+1];
        dfs(0);
        int ans=0;
        for(int b=0;b<=B;b++) ans=Math.max(ans,dp[0][0][b]);
        return ans;
    }

    int[] merge(int[] a,int[] b){
        int[] c=new int[B+1];
        Arrays.fill(c,Integer.MIN_VALUE/2);
        for(int i=0;i<=B;i++) if(a[i]>=0)
            for(int j=0;i+j<=B;j++)
                c[i+j]=Math.max(c[i+j],a[i]+b[j]);
        return c;
    }

    void dfs(int u){
        for(int v:g[u]) dfs(v);
        for(int pb=0;pb<2;pb++){
            int price=pb==1?p[u]/2:p[u], prof=f[u]-price;
            int[] skip=new int[B+1];
            for(int v:g[u]) skip=merge(skip,dp[v][0]);
            int[] take=new int[B+1];
            Arrays.fill(take,Integer.MIN_VALUE/2);
            if(price<=B){
                int[] base=new int[B+1];
                for(int v:g[u]) base=merge(base,dp[v][1]);
                for(int b=price;b<=B;b++) take[b]=base[b-price]+prof;
            }
            for(int b=0;b<=B;b++) dp[u][pb][b]=Math.max(skip[b],take[b]);
        }
    }
}
