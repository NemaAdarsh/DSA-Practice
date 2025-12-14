class Solution{
    public int numberOfWays(String c){
        long mod=1000000007,res=1;
        int seats=0,plants=0;
        for(char x:c.toCharArray()){
            if(x=='S'){
                seats++;
                if(seats>2&&seats%2==1){
                    res=res*(plants+1)%mod;
                    plants=0;
                }
            }else if(seats%2==0&&seats>0) plants++;
        }
        return seats%2==0&&seats>0?(int)res:0;
    }
}
