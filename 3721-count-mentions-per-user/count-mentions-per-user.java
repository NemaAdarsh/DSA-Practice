class Solution{
    public int[] countMentions(int n,List<List<String>> e){
        int[] m=new int[n],off=new int[n];
        boolean[] on=new boolean[n];
        java.util.Arrays.fill(on,true);

        e.sort((a,b)->{
            int t=Integer.parseInt(a.get(1))-Integer.parseInt(b.get(1));
            if(t!=0) return t;
            return a.get(0).equals("OFFLINE")?-1:1;
        });

        for(List<String> x:e){
            int ts=Integer.parseInt(x.get(1));
            for(int i=0;i<n;i++) if(!on[i]&&off[i]<=ts) on[i]=true;

            if(x.get(0).equals("OFFLINE")){
                int id=Integer.parseInt(x.get(2));
                on[id]=false;
                off[id]=ts+60;
            }else{
                String s=x.get(2);
                if(s.equals("ALL")){
                    for(int i=0;i<n;i++) m[i]++;
                }else if(s.equals("HERE")){
                    for(int i=0;i<n;i++) if(on[i]) m[i]++;
                }else{
                    for(String p:s.split(" ")){
                        m[Integer.parseInt(p.substring(2))]++;
                    }
                }
            }
        }
        return m;
    }
}
