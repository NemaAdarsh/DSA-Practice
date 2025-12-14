class Solution{
    public int[] intersect(int[] a,int[] b){
        java.util.Map<Integer,Integer> m=new java.util.HashMap<>();
        for(int x:a) m.put(x,m.getOrDefault(x,0)+1);
        java.util.List<Integer> r=new java.util.ArrayList<>();
        for(int x:b){
            int c=m.getOrDefault(x,0);
            if(c>0){r.add(x);m.put(x,c-1);}
        }
        int[] o=new int[r.size()];
        for(int i=0;i<o.length;i++) o[i]=r.get(i);
        return o;
    }
}
