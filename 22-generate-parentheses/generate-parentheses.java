class Solution{
    public List<String> generateParenthesis(int n){
        List<String> r=new java.util.ArrayList<>();
        dfs(r,"",0,0,n);
        return r;
    }
    void dfs(List<String> r,String s,int o,int c,int n){
        if(s.length()==2*n){r.add(s);return;}
        if(o<n) dfs(r,s+"(",o+1,c,n);
        if(c<o) dfs(r,s+")",o,c+1,n);
    }
}
