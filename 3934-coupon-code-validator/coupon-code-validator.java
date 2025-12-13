class Solution{
    public List<String> validateCoupons(String[] c,String[] b,boolean[] a){
        java.util.Map<String,Integer> o=java.util.Map.of("electronics",0,"grocery",1,"pharmacy",2,"restaurant",3);
        List<String[]> v=new java.util.ArrayList<>();
        for(int i=0;i<c.length;i++)
            if(a[i]&&c[i]!=null&&!c[i].isEmpty()&&c[i].matches("\\w+")&&o.containsKey(b[i]))
                v.add(new String[]{b[i],c[i]});
        v.sort((x,y)->{
            int d=o.get(x[0])-o.get(y[0]);
            return d!=0?d:x[1].compareTo(y[1]);
        });
        List<String> r=new java.util.ArrayList<>();
        for(String[] x:v) r.add(x[1]);
        return r;
    }
}
