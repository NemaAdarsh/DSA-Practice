class Solution {
    int[] p;
    int find(int x){
        return p[x]==x?x:(p[x]=find(p[x]));
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        p=new int[c+1];
        for(int i=1;i<=c;i++) p[i]=i;
        for(int[] e:connections){
            int a=find(e[0]),b=find(e[1]);
            if(a!=b) p[b]=a;
        }
        Map<Integer,TreeSet<Integer>> mp=new HashMap<>();
        for(int i=1;i<=c;i++){
            int r=find(i);
            mp.computeIfAbsent(r,k->new TreeSet<>()).add(i);
        }
        boolean[] on=new boolean[c+1];
        Arrays.fill(on,true);
        List<Integer> res=new ArrayList<>();
        for(int[] q:queries){
            if(q[0]==2){
                if(on[q[1]]){
                    on[q[1]]=false;
                    int r=find(q[1]);
                    mp.get(r).remove(q[1]);
                }
            }else{
                if(on[q[1]]) res.add(q[1]);
                else{
                    int r=find(q[1]);
                    if(!mp.get(r).isEmpty()) res.add(mp.get(r).first());
                    else res.add(-1);
                }
            }
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++) ans[i]=res.get(i);
        return ans;
    }
}
