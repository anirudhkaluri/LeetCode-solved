class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ans=new ArrayList();
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
               
                if(!checkSimplification(i,j))
                    ans.add(String.valueOf(j)+"/"+String.valueOf(i));
            }
        }
        return ans;
    }

    //returns true there is a common divisor between i and j
    public Boolean checkSimplification(int i,int j){
        int limit=(int)Math.sqrt(j)+1;
        if(i%j==0 && j!=1)
            return true;
        for(int z=2;z<=j;z++){
            if(i%z==0 && j%z==0)
                return true;
        }
        return false;
    }
}