class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n=nums.length;
        int[]prezero=new int[n];
        prezero[0]=nums[0]==0?1:0;
        int[]sufone=new int[n];
        sufone[n-1]=nums[n-1]==1?1:0;
        
        for(int i=1;i<=n-1;i++){
            prezero[i]=prezero[i-1]+(nums[i]==0?1:0);
            sufone[n-i-1]=sufone[n-i]+(nums[n-i-1]==1?1:0);
        }
        List<Integer>ans=new ArrayList();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            int divscore= (i==0?0:prezero[i-1])+(i==n?0:sufone[i]);
            if(divscore>max){
                ans.clear();
                ans.add(i);
                max=divscore;
            }
            else if(divscore==max){
                ans.add(i);
            }
        }
        return ans;
    }
}