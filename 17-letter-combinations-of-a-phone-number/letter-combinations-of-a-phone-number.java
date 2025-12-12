class Solution{
    public List<String> letterCombinations(String d){
        List<String> r=new java.util.ArrayList<>();
        if(d.isEmpty()) return r;
        String[] m={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        r.add("");
        for(char c:d.toCharArray()){
            List<String> t=new java.util.ArrayList<>();
            for(String a:r) for(char x:m[c-'0'].toCharArray()) t.add(a+x);
            r=t;
        }
        return r;
    }
}
